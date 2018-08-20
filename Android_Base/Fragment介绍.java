// 静态使用:在onCreateView中解析xml
View view=inflater.inflate(R.layout.fragment_main,container);
return view;

// 动态使用:MainActivity的onCreate()
// 初始化h可能动态切换的Fragment2、3、4
// 设置4个按钮，点击new对应的Fragment
if(tabFragmentX == null){
	tabFragmentX=new CommontFragment("X");
}
ft.replace(R.id.container,tabFragmentX);

// 默认显示Fragment1
FragmentTransaction ft=getFragmentManager().beginTransaction();
tabFragment1=new CommonFragment("1");
//t 替换
ft.replace(R.id.container,tabFragment1);
ft.commit();

// 相关类及主要用法
FragmentManager manager=getFragmentManager();
FragmentTransaction transaction=manager.beginTransaction();
// 添加
transaction.add();
transaction.replace();
transaction.remove();
// 隐藏与销毁,2个接口会触发onHiddenChanged(bool hidden)回调
transaction.hide();
transaction.show();
// 显示之前的数据，实例不销毁毁，视图层会销毁，会调用onDestroyView()、onCreateView()
transaction.addToBackStack(null);
transaction.commit();

// Fragment相关接口
// 返回关联Activity
fragment.getActivity();
// 设置数据
fragment.setArguments(new Bundle());
// 获取数据
fragment.getArguments();
// 返回与Fragment作用的FragmentMananger
fragment.getFragmentManager();
// 隐藏状态改变时回调
onHiddenChanged(true);

