import Foundation
import shared

class DIContainer {

    static let shared = DIContainer()

    private init() {}

    private lazy var sharedModule = SharedModule.shared

    func provideTodoRepository() -> TodoRepository {
        return sharedModule.provideTodoRepository()
    }

    func provideGetTodoTitleUseCase() -> GetTodoTitleUseCase {
        return sharedModule.provideGetTodoTitleUseCase()
    }

    func provideGetUrlUseCase() -> GetUrlUseCase {
        return sharedModule.provideGetUrlUseCase()
    }

    func resolve<T>(_ type: T.Type) -> T {
        switch type {
        case is MainViewModel.Type:
            return makeMainViewModel() as! T
        default:
            fatalError("No factory registered for type \(type)")
        }
    }

    private func makeMainViewModel() -> MainViewModel {
        return MainViewModel(
            getTodoTitleUseCase: provideGetTodoTitleUseCase(),
            getUrlUseCase: provideGetUrlUseCase()
        )
    }
}
