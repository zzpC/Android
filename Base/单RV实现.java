public class NormalItemBean {
	private String title;
	private int itemId;
	private boolean isChecked;

	//getter/setter方法
}

public class GroupItemBean {
	private String title;
	private int itemId;
	private boolean isChecked;
	private List<ChildItemBean> childs;

	//getter/setter方法
	public List<ChildItemBean>
	public void setChilds(List<ChildItemBean> childs) {
		this.childs=childs;
	}

}

public class ChildItemBean {
	private String title;
	private boolean isChecked;
	private int groupId;
	private int itemId;

	//getter/setter方法

}

//XXBean的父类
public class DemoItemBean {
	public static final int TYPE_NORMAL=0;
	public static final int TYPE_GROUOP=1;
	public static final int TYPE_CHILD=2;

	private String title;
	private boolean isChecked;
	private int itemType;
	public int itemId;

	//getter/setter方法
}
//可以通过类的机制调整结构

public class ParseHelper {
	private static List<NormalItemBean> getNormalDatas() {
		List<NormalItemBean> list=new ArrayList<>();
		//用setter方法模拟返回数据
		NormalItemBean bean=new NormalItemBean();
		list.add(bean);
		return list;
	}

	public static List<GroupItemBean> getGroupDatas(){
	
	}
	
	public static List<DemoItemBean> getParseDatas() {
	
	}
}
//完成适配器
public DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	private List<DemoItemBean> mDatas;
	private Context mContext;
	private OnCheckChangeListener onCheckChangeListener;
	
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
		
	}

	public void onBindViewHolder(final RecyclerView.ViewHolder holder,final int position) {
		if (holder instanceof NormalViewHolder) {
			NormalViewHolder nHolder=(NormalViewHolder) holder;
			nHolder.bindData((NormalViewHolder)mDatas.get(position));
			
		}else if(){
		
		}else if(){
		
		}
	}

	public class OnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {
	
	}
}

public class NormalViewHolder extends RecyclerView.ViewHolder {
	private NormalItemBean bean;
	public LinearLayout llNoraml;
	public CheckkBox cbNormal;

	public void bindData(NormalItemBean bean) {
		this.bean=bean;
	}

	private class OnClickListener implements View.OnClickListener{
	
	}
}

public class GroupViewHolder extends RecyclerView.ViewHolder {
	private GroupItemBean bean;
	public TextView tvGroup,tvSub1,tvSub2,tvSub3;
	public CheckBox cbGroup;
	public LinearLayout llGroup,subEdit;
}

public class ChildViewHolder extends RecyclerView.ViewHolder{
	private ChildItemBean bean;
	public TextView tvChild;
	public CheckBox cbChild;
	public LinearLayout llChild;
}
