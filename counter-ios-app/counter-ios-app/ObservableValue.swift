import CounterShared

public class ObservableValue<T : AnyObject> : ObservableObject {
    private let observableValue: DecomposeValue<T>
    
    @Published
    var value: T
    
    private var observer: ((T) -> Void)?
    
    init(_ value: DecomposeValue<T>) {
        self.observableValue = value
        self.value = observableValue.value
        self.observer = { value in self.value = value }
 
        observableValue.subscribe(observer: observer!)
    }
    
    deinit {
        self.observableValue.unsubscribe(observer: self.observer!)
    }
}
