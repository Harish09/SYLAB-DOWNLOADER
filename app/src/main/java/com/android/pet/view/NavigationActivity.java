package com.android.pet.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.doepiccoding.navigationdrawer.R;

public class NavigationActivity extends FragmentActivity {

    private DrawerLayout mDrawerLayout;

    ImageView home;

    Fragment fragment = null;

    TextView appname;
    Button openButton;

    private static final String ARG_PARAM1 = "fileName";
    private static final String ARG_PARAM2 = "url";


    ExpandableListView expListView;
    ExpandableListAdapter listAdapter;

    private String[] subjectNames = {"TE1", "M1", };
    private String[] urls = {};
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String fontPath = "fonts/Shadow Boxing.ttf";
        String newFontPath = "fonts/CircleD_Font_by_CrazyForMusic.ttf";
        setContentView(R.layout.activity_navigation);

        if(getActionBar() != null)
            getActionBar().setDisplayHomeAsUpEnabled(true);

        home = (ImageView)findViewById(R.id.home);
        home.setOnClickListener(homeOnclickListener);

        appname = (TextView)findViewById(R.id.appname);
        openButton = (Button) findViewById(R.id.open_btn);

        Typeface tf = Typeface.createFromAsset(this.getAssets(), fontPath);
        Typeface tf1 = Typeface.createFromAsset(this.getAssets(), newFontPath);

        appname.setTypeface(tf);
        openButton.setTypeface(tf1);

        setUpDrawer();
    }

    //Get the names and icons references to build the drawer menu...
    private void setUpDrawer() {

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));
        mDrawerLayout.setDrawerListener(mDrawerListener);

        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        prepareListData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        fragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();

        mDrawerLayout.closeDrawer(expListView);

        expListView.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                switch (groupPosition) {
                    case 0://Sem 1
                        switch (childPosition) {
                            case 0://Technical English 1
                                fragment = new DisplayFragment();
                                Bundle args = new Bundle();
                                args.putString(ARG_PARAM1, subjectNames[groupPosition * 6 + childPosition]);
                                args.putString(ARG_PARAM2, " ");
                                fragment.setArguments(args);
                                //fragment = new M1Fragment();
                                break;
                            case 1://Technical Maths 1
                                fragment = new M1Fragment();

                                break;
                            case 2:
                                //fragment = new HomeFragment();
                                break;
                            default:
                                break;
                        }
                        break;

                    case 1://Sem 2
                        switch (childPosition) {
                            case 0:
                                //	fragment = new M2Fragment();
                                break;
                            case 1: //Mathematics II
                                fragment = new M2Fragment();
                                break;
                            case 2: //Computational Physics
                                fragment = new PCEFragment();
                                break;
                            case 3:
                                fragment = new CPFragment();
                                break;
                            case 4:
                                fragment = new pcplusplus();
                                break;
                            case 5:
                                fragment = new dpsd();
                                break;
                            case 6:
                                fragment = new prglab();
                                break;
                            case 7:
                                fragment = new digilab();
                                break;
                            default:
                                break;
                        }
                        break;

                    case 2://Sem 3
                        switch (childPosition) {
                            case 0:
                                //fragment = new M1Fragment();
                                break;
                            case 1:
                                //fragment = new VenusFragment();
                                break;
                            case 2:
                                //fragment = new HomeFragment();
                                break;
                            default:
                                break;
                        }
                        break;

                    default:
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
                mDrawerLayout.closeDrawer(expListView);
                return false;
            }
        });
    }

    View.OnClickListener homeOnclickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mDrawerLayout.isDrawerOpen(expListView)){
                mDrawerLayout.closeDrawer(expListView);
            }else{
                mDrawerLayout.openDrawer(expListView);
            }
        }
    };

    private OnItemClickListener mDrawerItemClickedListener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

            switch(position){
                case 0: //represents the fragment on clicking Sem 1 group title
                    fragment = new M1Fragment();
                    break;
                case 1://sem 2 group title
                    fragment = new VenusFragment();
                    break;
                case 2: //sem 3 group title
                    fragment = new HomeFragment();
                    break;
                default:
                    return;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerLayout.closeDrawer(expListView);
        }
    };

    // Catch the events related to the drawer to arrange views according to this
    // action if necessary...
    private DrawerListener mDrawerListener = new DrawerListener() {

        @Override
        public void onDrawerStateChanged(int status) {

        }

        @Override
        public void onDrawerSlide(View view, float slideArg) {

        }

        @Override
        public void onDrawerOpened(View view) {
        }

        @Override
        public void onDrawerClosed(View view) {
        }
    };

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Adding child data - All sem titles represent a group button
        listDataHeader.add("Sem 1");
        listDataHeader.add("Sem 2");
        listDataHeader.add("Sem 3");
        listDataHeader.add("Sem 4");
        listDataHeader.add("Sem 5");
        listDataHeader.add("Sem 6");
        listDataHeader.add("Sem 7");
        listDataHeader.add("Sem 8");

        // Adding child data
        List<String> s1 = new ArrayList<>();
        s1.add("Technical English 1");
        s1.add("mathematics 1");
        s1.add("Engineering Physics");
        s1.add("Engineering Chemistry");
        s1.add("Engineering Graphics");
        s1.add("Computing Techniques");
        s1.add("Physics Lab");
        s1.add("Chemistry Lab");
        s1.add("Engineering Practise Lab");
        s1.add("Computing Techniques Lab");

        List<String> s2 = new ArrayList<>();
        s2.add("Technical English 2");
        s2.add("Mathematics 2");
        s2.add("principles of Computer Engineering");
        s2.add("Physics for Information Science");
        s2.add("Programing using C++");
        s2.add("Digital Principles and System Design");
        s2.add("Programing Laboratory");
        s2.add("Digital Laboratory");


        List<String> s3 = new ArrayList<>();
        s3.add("Algebra and Number Theory");
        s3.add("EDC");
        s3.add("Data Structures");
        s3.add("DBMS");
        s3.add("EVS");
        s3.add("Computer Architecture");
        s3.add("DBMS Lab");
        s3.add("Data Structures Lab");


        List<String> s4 = new ArrayList<>();
        s4.add("Electrical Engineering and Control Systems");
        s4.add("Design and Analysis of Algorithms");
        s4.add("Operating Systems");
        s4.add("Java and Internet Programing");
        s4.add("Probability and Queuing Theory");
        s4.add("Sofware Engineering");
        s4.add("Operating Systems Lab");
        s4.add("Java and Internet Programing Lab");



        List<String> s5 = new ArrayList<>();
        s5.add("Object oriented Analysis and Design");
        s5.add("Theory Of Computation");
        s5.add("Software System Internals");
        s5.add("Microprocessors and Micro Controllers");
        s5.add("Data Communication and Computer Networks");
        s5.add("Employability Skills");
        s5.add("Communications and Networks Laboratory");
        s5.add("Case Tools lab");
        s5.add("Microprocessor lab");

        List<String> s6 = new ArrayList<>();
        s6.add("Artificial Intelligence");
        s6.add("DSP");
        s6.add("Computer Graphics and Multimedia");
        s6.add("Compiler Design");
        s6.add("Programing Paradigms");
        s6.add("Creative and Innovative project");
        s6.add("Computer Graphics and Multimedia laboratory");



        listDataChild.put(listDataHeader.get(0), s1); // Header, Child data
        listDataChild.put(listDataHeader.get(1), s2);
        listDataChild.put(listDataHeader.get(2), s3);
        listDataChild.put(listDataHeader.get(3), s4);
        listDataChild.put(listDataHeader.get(4), s5);
        listDataChild.put(listDataHeader.get(5), s6);
    }

    public class ExpandableListAdapter extends BaseExpandableListAdapter {

        private Context _context;
        private List<String> _listDataHeader; // header titles
        // child data in format of header title, child title
        private HashMap<String, List<String>> _listDataChild;

        public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                     HashMap<String, List<String>> listChildData) {
            this._context = context;
            this._listDataHeader = listDataHeader;
            this._listDataChild = listChildData;
        }

        @Override
        public Object getChild(int groupPosition, int childPosititon) {
            return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                    .get(childPosititon);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getChildView(int groupPosition, final int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {

            final String childText = (String) getChild(groupPosition, childPosition);

            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) this._context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.list_item, null);
            }

            TextView txtListChild = (TextView) convertView
                    .findViewById(R.id.lblListItem);

            txtListChild.setText(childText);
            return convertView;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                    .size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return this._listDataHeader.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return this._listDataHeader.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            String headerTitle = (String) getGroup(groupPosition);
            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) this._context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.list_group, null);
            }

            TextView lblListHeader = (TextView) convertView.findViewById(R.id.lblListHeader);
            lblListHeader.setTypeface(null, Typeface.BOLD);
            lblListHeader.setText(headerTitle);

            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
}
