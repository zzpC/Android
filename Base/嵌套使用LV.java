public class ARecyclerView extends {

	protected void onMeasure(int widthMeasureSpec,int heightMeasure){
		int expandSpec=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasure,expandSpec);
	}
}
