import SwiftUI
import Combine
import shared

class MainViewModel: ObservableObject {

    @Published var toastMessage: String?
    @Published var isLoading: Bool = false
    @Published var webViewUrl: String

    private let getTodoTitleUseCase: GetTodoTitleUseCase
    private let getUrlUseCase: GetUrlUseCase

    init(
        getTodoTitleUseCase: GetTodoTitleUseCase,
        getUrlUseCase: GetUrlUseCase
    ) {
        self.getTodoTitleUseCase = getTodoTitleUseCase
        self.getUrlUseCase = getUrlUseCase
        self.webViewUrl = getUrlUseCase.execute()
    }

    func loadTodoTitle() {
        isLoading = true

        getTodoTitleUseCase.execute(todoId: 1) { [weak self] result, error in
            guard let self = self else { return }

            DispatchQueue.main.async {
                self.isLoading = false

                if let error = error {
                    self.toastMessage = error.localizedDescription
                    return
                }

                if let success = result as? ResultSuccess<NSString> {
                    self.toastMessage = success.data as String
                } else if let errorResult = result as? ResultError {
                    self.toastMessage = errorResult.message ?? "Unable to load title"
                }
            }
        }
    }

    func clearToastMessage() {
        toastMessage = nil
    }
}
