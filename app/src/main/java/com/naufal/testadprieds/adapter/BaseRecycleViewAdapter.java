package com.naufal.testadprieds.adapter;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Drawer adapter.   
 * @author Anthony Le
 */
public abstract class BaseRecycleViewAdapter<T, VH extends BaseRecycleViewAdapter.ViewHolder> extends RecyclerView.Adapter<VH> {

	private List<T> list = new ArrayList<T>();
	private int pageIndex = 1;
	public int rowIndex = -1;

	protected OnItemClickListener onItemClickListener;

	public T getItem(int position){
		if(list != null && list.size() > position){
			return list.get(position);
		}
		return null;
	}

	@Override
	public int getItemCount() {
		return list.size();
	}

	public void setData(List<T> list){
		if(list != null){
			this.list = list;
		}
		notifyDataSetChanged();
	}

	public void setData(T t, int index){
		if(list != null && list.size() > index){
			list.set(index, t);
			notifyItemChanged(index);
		}
	}

	public void removeData(int index){
		if(list != null && list.size() > index){
			list.remove(index);
			notifyItemRemoved(index);
			notifyItemRangeChanged(index, list.size());
		}
	}

	public void setEditData(List<T> list){
		if(list != null){
			this.list = list;
		}
	}

	public void clear(){
		list.clear();
		notifyDataSetChanged();
	}

	public int getPageIndex(){
		return pageIndex;
	}

	public void addData(int pageIndex, List<T> list) {
		this.pageIndex = pageIndex;
		addData(list);
	}

	public void addData(List<T> list){
		int listSize = this.list.size();
		this.list.addAll(list);
		notifyItemInserted(listSize);
	}

	public List<T> getData(){
		return list;
	}


	@Override
	public void onBindViewHolder(VH holder,  int position) {
		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (onItemClickListener != null) {
					Log.e("","BaseRecycleViewAdapter Click ");
					rowIndex = position;
					onItemClickListener.onItemClick(holder.itemView, position, holder.item);
					notifyDataSetChanged();
				}
			}
		});
	}

	public void setOnClickListener(OnItemClickListener onItemClickListener){
		this.onItemClickListener = onItemClickListener;
	}


	public interface OnItemClickListener<T> {

		void onItemClick(View v, int position, T item);
	}

	public static abstract class ViewHolder<T> extends RecyclerView.ViewHolder {

		public T item;

		public ViewHolder(View view) {
			super(view);

		}
	}
}
