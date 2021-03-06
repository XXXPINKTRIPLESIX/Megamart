//package com.example.megamart.adapters;
//
//import android.content.Context;
//import android.graphics.Typeface;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseExpandableListAdapter;
//import android.widget.TextView;
//
//import com.example.megamart.R;
//import com.example.megamart.business.models.Category;
//
//import java.util.HashMap;
//import java.util.List;
//
//public class OLDCategoryListViewAdapter extends BaseExpandableListAdapter {
//
//    private Context context;
//    private List<Category> expandableListTitle;
//    private HashMap<Category, List<Category>> expandableListDetail;
//
//    public OLDCategoryListViewAdapter(Context context, List<Category> expandableListTitle, HashMap<Category, List<Category>> expandableListDetail) {
//        this.context = context;
//        this.expandableListTitle = expandableListTitle;
//        this.expandableListDetail = expandableListDetail;
//    }
//
//    @Override
//    public int getGroupCount() {
//        return this.expandableListTitle.size();
//    }
//
//    @Override
//    public int getChildrenCount(int groupPosition) {
//        return this.expandableListDetail.get(this.expandableListTitle.get(groupPosition))
//                .size();
//    }
//
//    @Override
//    public Object getGroup(int groupPosition) {
//        return this.expandableListTitle.get(groupPosition);
//    }
//
//    @Override
//    public Object getChild(int groupPosition, int childPosition) {
//        return this.expandableListDetail.get(this.expandableListTitle.get(groupPosition))
//                .get(childPosition);
//    }
//
//    @Override
//    public long getGroupId(int groupPosition) {
//        return groupPosition;
//    }
//
//    @Override
//    public long getChildId(int groupPosition, int childPosition) {
//        return childPosition;
//    }
//
//    @Override
//    public boolean hasStableIds() {
//        return false;
//    }
//
//    @Override
//    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
//        Category listTitle = (Category) getGroup(groupPosition);
//        if (convertView == null) {
//            LayoutInflater layoutInflater = (LayoutInflater) this.context.
//                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = layoutInflater.inflate(R.layout.expandable_list_group, null);
//        }
//        TextView listTitleTextView = (TextView) convertView
//                .findViewById(R.id.listTitle);
//        listTitleTextView.setTypeface(null, Typeface.BOLD);
//        listTitleTextView.setText(listTitle.name);
//        return convertView;
//    }
//
//    @Override
//    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
//        final Category expandedListText = (Category) getChild(groupPosition, childPosition);
//        if (convertView == null) {
//            LayoutInflater layoutInflater = (LayoutInflater) this.context
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = layoutInflater.inflate(R.layout.expandable_list_item, null);
//        }
//        TextView expandedListTextView = (TextView) convertView
//                .findViewById(R.id.expandedListItem);
//        expandedListTextView.setText(expandedListText.name);
//        return convertView;
//    }
//
//    @Override
//    public boolean isChildSelectable(int groupPosition, int childPosition) {
//        return true;
//    }
//}
