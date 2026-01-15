import SwiftUI

struct ContentView: View {

    @StateObject private var viewModel = DIContainer.shared.resolve(MainViewModel.self)
    @State private var showToast = false

    var body: some View {
        ZStack {
            WebView(url: viewModel.webViewUrl)
                .edgesIgnoringSafeArea(.all)

            if let message = viewModel.toastMessage, showToast {
                ToastView(message: message)
                    .transition(.move(edge: .bottom).combined(with: .opacity))
                    .onAppear {
                        scheduleToastDismissal()
                    }
            }

            if viewModel.isLoading {
                LoadingView()
            }
        }
        .onAppear {
            viewModel.loadTodoTitle()
        }
        .onChange(of: viewModel.toastMessage) { newValue in
            withAnimation(.easeInOut(duration: 0.3)) {
                showToast = newValue != nil
            }
        }
    }

    private func scheduleToastDismissal() {
        DispatchQueue.main.asyncAfter(deadline: .now() + 3) {
            withAnimation(.easeInOut(duration: 0.3)) {
                showToast = false
                viewModel.clearToastMessage()
            }
        }
    }
}

struct ToastView: View {
    let message: String

    var body: some View {
        Text(message)
            .padding()
            .background(Color.black.opacity(0.8))
            .foregroundColor(.white)
            .cornerRadius(8)
            .padding(.horizontal, 20)
            .padding(.bottom, 50)
            .frame(maxHeight: .infinity, alignment: .bottom)
    }
}

struct LoadingView: View {
    var body: some View {
        ProgressView()
            .scaleEffect(1.5)
            .progressViewStyle(CircularProgressViewStyle(tint: .primary))
            .frame(maxWidth: .infinity, maxHeight: .infinity)
            .background(Color.black.opacity(0.2))
    }
}
