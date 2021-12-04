import SwiftUI
import CounterShared

struct CounterUi: View {
    
    private let counter: Counter
    
    @ObservedObject
    private var models: ObservableValue<CounterModel>
    
    init(counter: Counter) {
        self.counter = counter
        self.models = ObservableValue(counter.models)
    }

    var body: some View {
        let model = self.models.value
        
        VStack {
            Button (action: self.counter.onIncrement, label: {
                Image(systemName: "plus")
            })
            Text("Count: \(model.count)")
 
            Button (action: self.counter.onDecrement, label: {
                Image(systemName: "minus")
            })
        }
    }
}

struct CounterUi_Previews: PreviewProvider {
    static var previews: some View {
        CounterUi(counter: CounterPreview())
            .previewDevice("iPhone SE (2nd generation)")
    }
}

class CounterPreview: Counter {
    
    var models: DecomposeValue<CounterModel> = DecomposeMutableValue.init(CounterModel(count: 10))

    func onIncrement() {}
 
    func onDecrement() {}
}
