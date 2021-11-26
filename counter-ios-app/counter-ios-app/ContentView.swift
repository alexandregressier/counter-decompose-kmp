import SwiftUI
import CounterShared

struct ContentView: View {
    
    private let greet = Greeting().greeting()
 
    var body: some View {
        Text(greet)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
            .previewDevice("iPhone SE (2nd generation)")
    }
}
