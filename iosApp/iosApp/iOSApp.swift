import SwiftUI

@main
struct iOSApp: App {

    init() {
        _ = DIContainer.shared
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
