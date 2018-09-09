// 被观察者Observable 通过 订阅(Subscribe) 按顺序发送事件(Event) 给 观察者(Observer)
// 观察者通过顺序接收事件作出对应的相应动作

// 步骤
// 步骤1 创建Observable:
Observable<Integer> observable=Observable.create(new ObservableOnSubscribe<Integer>() {
	public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
		emitter.onNext(1);
		emitter.onNext(2);
		emitter.onNext(3);
		emitter.onComplete();
	}
});
// 其它方式
Observable observable=Observable.just("A","B","C");
String[] words={"A","B","C"};
Observalbe observable=Observable.from(words);


// 步骤2 创建观察者Observer
// 采用接口
Observer<Integer> observer=new Observer<Integer>() {
	public void onSubscribe(Disposable d){
	
	}
	public void onNext(Integer vaulue) {
	
	}
	public void onError(Throwable e) {
	
	}
	public void onComplete() {
	
	}	
};
// 采用Subscriber抽象类内置了Observable
Subscriber<String> subscriber=new Subscriber<Integer>() {
	public void onSubscribe(Subscription s) {
		
	}
	public void onNext(Integer value) {
	
	}
	public void onError(Throwable e){
	
	}
	public void onComplete(){
	
	}
};

// 步骤3 ubscribe()的连接作用
Observable.subscribe(observer);
// 扩展说明,subscribe的内部实现
public Subscription subscribe(Subscriber subscriber) {
	subscriber.onStart();
	onSubscribe.call(subscriber);
}

// 事件流的链式调用
// 顺序:观察者.onSubscribe() > 被观察者.subscribe() > 观察者.onNext() > 观察者.onComplete()

// 提供了多个函数式接口,可便捷实现观察者模式
Observable.just("hello").subscribe(new Consumer<String>() {
	public void accept(String s) throws Exception {
		System.out.println(s);
	}
});
