// android/8.0.0_r4/xref/frameworks/rs/cpp/util/RefBase.h

template <typename T>
class wp{
public:
	typedef typename RefBase::weakref_type weakref_type;
	inline wp():m_ptr(0){}

	// 
	wp(T* other);
	wp(const wp<T>& other);
	wp(const sp<T>& other);
	template<typename U> wp(const sp<U>& other);	
	template<typename U> wp(const wp<U>& other);	
	~wp();
	// 赋值构造函数
	
	// 弱引用提升
	sp<T> promote() const;
	
	// Reset
	void clear(); 
}

// -----------------------------------------------------------
class RefBase{
public:
	void incStrong(const void* id) const;
	void decStrong(const void* id) const;
	void forceIncStrong(const void* id) const;

	int32_t getStrongCount() const;

	// 操作弱指针的方法通过内部类和强指针分开
	class weakref_type{
	public:
		RefBase* refBase() const;
		void incWeak(const void* id);
		void decWeak(cosnt void* id);
	}
}
