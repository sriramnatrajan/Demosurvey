package com.biits.demosurvey;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.biits.demosurvey.Model.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ExpAdapter extends BaseExpandableListAdapter {
    public ArrayList<String> selectedAnswers;
    private Context mContext;
    private List<String> mQuestionList = new ArrayList<>();
    private Map<String, List<Question>> mExpandListDetails = new HashMap<>();
    LayoutInflater mLayoutInflater;
    List<Question> questionList;
    HashMap<Integer,Integer> mLastIndexVal=new HashMap<>();
    String mQId;

    ExpAdapter(Context context, List<Question> questionList) {
        mContext = context;
        int length = questionList.size();
        int startIndex = 0;
        selectedAnswers = new ArrayList<>();
        String question = (length > 0) ? questionList.get(0).getQuestion() : "";
        // mQId=(length>0)?questionList.get(0).getQuestionno():"";
        for (int i = 0; i < questionList.size(); i++) {

            Question mQuestion1 = questionList.get(i);
            if (!mQuestion1.getQuestion().equalsIgnoreCase(question)) {
                List<Question> mQList = questionList.subList(startIndex, i);
                mExpandListDetails.put(question, mQList);
                mQuestionList.add(question);
                mLastIndexVal.put(startIndex,-1);
                selectedAnswers.add("not filled");
                question = mQuestion1.getQuestion();
                startIndex = i;
            }
        }
        if (startIndex != questionList.size()) {
            mExpandListDetails.put(question, questionList.subList(startIndex, questionList.size()));
            mQuestionList.add(question);
        }
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
//        final Question question = questionList.get(position);

    @Override
    public Object getChild(int listPosition, int expandendListPosition) {
        return mExpandListDetails.get(mQuestionList.get(listPosition)).get(expandendListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandendListPosition) {
        return expandendListPosition;
    }

    @Override
    public View getChildView(final int listPosition, final int expandlistPosition, boolean isLastChild, View convertView, ViewGroup parent) {
     Question mQuestion1=(Question)getChild(listPosition,expandlistPosition);
        final String content;
        final String option_one = ((Question) getChild(listPosition, expandlistPosition)).getOptionone();
        final String option_two = ((Question) getChild(listPosition, expandlistPosition)).getOptiontwo();
        final String option_three = ((Question) getChild(listPosition, expandlistPosition)).getOptionthree();
        final String option_four = ((Question) getChild(listPosition, expandlistPosition)).getOptionfour();

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_content, null);

        }

        final RadioGroup radiogroupSingle = (RadioGroup) convertView.findViewById(R.id.radioGroup_single);
        //RadioButton radio_OptionId = (RadioButton)convertView.findViewById(selectedoptionId);


        final RadioButton radio_option1 = (RadioButton) convertView.findViewById(R.id.radio_option1);
        final RadioButton radio_option2 = (RadioButton) convertView.findViewById(R.id.radio_option2);
        final RadioButton radio_option3 = (RadioButton) convertView.findViewById(R.id.radio_option3);
        final RadioButton radio_option4 = (RadioButton) convertView.findViewById(R.id.radio_option4);
        final EditText EditText_comments = (EditText) convertView.findViewById(R.id.EditText_comments);


        LinearLayout Liner_single = (LinearLayout) convertView.findViewById(R.id.Liner_single);
        LinearLayout Liner_multiple = (LinearLayout) convertView.findViewById(R.id.Liner_multiple);
        LinearLayout Liner_comments = (LinearLayout) convertView.findViewById(R.id.Liner_comments);
        LinearLayout Linear_question = (LinearLayout) convertView.findViewById(R.id.Linear_question);
        LinearLayout Liner_option = (LinearLayout) convertView.findViewById(R.id.Liner_option);


        CheckBox checkbox_option1 = (CheckBox) convertView.findViewById(R.id.checkbox_option1);
        CheckBox checkbox_option2 = (CheckBox) convertView.findViewById(R.id.checkbox_option2);
        CheckBox checkbox_option3 = (CheckBox) convertView.findViewById(R.id.checkbox_option3);
        CheckBox checkbox_option4 = (CheckBox) convertView.findViewById(R.id.checkbox_option4);

        radio_option1.setText(option_one);
        radio_option2.setText(option_two);
        radio_option3.setText(option_three);
        radio_option4.setText(option_four);

        String questiontype = ((Question) getChild(listPosition, expandlistPosition)).getQuestiontype();
        if (questiontype.equals("option")) {


            Liner_single.setVisibility(View.VISIBLE);
            Liner_multiple.setVisibility(View.GONE);
            Liner_comments.setVisibility(View.GONE);

            radio_option1.setText(((Question) getChild(listPosition, expandlistPosition)).getOptionone());
            radio_option2.setText(((Question) getChild(listPosition, expandlistPosition)).getOptiontwo());
            radio_option3.setText(((Question) getChild(listPosition, expandlistPosition)).getOptionthree());
            radio_option4.setText(((Question) getChild(listPosition, expandlistPosition)).getOptionfour());

            if (((Question) getChild(listPosition, expandlistPosition)).getOptionone() != null)
                radio_option1.setVisibility(View.VISIBLE);


            if (((Question) getChild(listPosition, expandlistPosition)).getOptiontwo() != null)
                radio_option2.setVisibility(View.VISIBLE);

            if (((Question) getChild(listPosition, expandlistPosition)).getOptionthree() != null) {
                radio_option3.setVisibility(View.VISIBLE);
            } else {
                radio_option3.setVisibility(View.GONE);
            }
            if (((Question) getChild(listPosition, expandlistPosition)).getOptionfour() != null) {
                radio_option4.setVisibility(View.VISIBLE);
            } else {
                radio_option4.setVisibility(View.GONE);
            }

        } else if (questiontype.equalsIgnoreCase("comment")) {


            Liner_single.setVisibility(View.GONE);
            Liner_multiple.setVisibility(View.GONE);
            Liner_comments.setVisibility(View.VISIBLE);

            String answer = EditText_comments.getText().toString();

        } else {
            Liner_single.setVisibility(View.GONE);
            Liner_multiple.setVisibility(View.VISIBLE);
            Liner_comments.setVisibility(View.GONE);


            checkbox_option1.setText(((Question) getChild(listPosition, expandlistPosition)).getOptionone());
            checkbox_option2.setText(((Question) getChild(listPosition, expandlistPosition)).getOptiontwo());
            checkbox_option3.setText(((Question) getChild(listPosition, expandlistPosition)).getOptionthree());
            checkbox_option4.setText(((Question) getChild(listPosition, expandlistPosition)).getOptionfour());


            if (((Question) getChild(listPosition, expandlistPosition)).getOptionone() != null)
                checkbox_option1.setVisibility(View.VISIBLE);

            if (((Question) getChild(listPosition, expandlistPosition)).getOptiontwo() != null)
                checkbox_option2.setVisibility(View.VISIBLE);

            if (((Question) getChild(listPosition, expandlistPosition)).getOptionthree() != null)
                checkbox_option3.setVisibility(View.VISIBLE);

            if (((Question) getChild(listPosition, expandlistPosition)).getOptionfour() != null)
                checkbox_option4.setVisibility(View.VISIBLE);
        }
/*
       radio_option1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                   if (isChecked) {
                        selectedAnswers.set(listPosition, ((Question) getChild(listPosition, expandlistPosition)).
                                getOptionone());
                    }
                }
            });*/
        radio_option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswers.set(listPosition, ((Question) getChild(listPosition, expandlistPosition)).
                        getOptionone());
                radiogroupSingle.check(radio_option1.getId());
            }
        });
        radio_option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswers.set(listPosition, ((Question) getChild(listPosition, expandlistPosition)).
                        getOptiontwo());
                radiogroupSingle.check(radio_option2.getId());
            }
        });
        radio_option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswers.set(listPosition, ((Question) getChild(listPosition, expandlistPosition)).
                        getOptionthree());
                radiogroupSingle.check(radio_option3.getId());
            }
        });
        radio_option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswers.set(listPosition, ((Question) getChild(listPosition, expandlistPosition)).
                        getOptionfour());
                radiogroupSingle.check(radio_option4.getId());
            }
        });



        content=EditText_comments.getText().toString();
       // EditText_comments.setText(mQuestion1.getEt_Answer().trim());

        selectedAnswers.set(listPosition,content);

        EditText_comments.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // EditText_comments.setText(s.toString());

                //selectedAnswers.set(listPosition,content);
            }

            @Override
            public void afterTextChanged(Editable s) {
                EditText_comments.setSelection(EditText_comments.getText().length());
                selectedAnswers.set(listPosition,content);
                // selectedAnswers.set(listPosition,content);
            }
        });
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return mExpandListDetails.get(mQuestionList.get(listPosition)).size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return mQuestionList.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return mQuestionList.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, final boolean isExpanded, View convertView, ViewGroup viewGroup) {
        //    final  RadioGroup radiogroupSingle = (RadioGroup) findViewById(R.id.radioGroup_single);

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_group, null);
        }
        TextView mTextView = (TextView) convertView.findViewById(R.id.textQuestion);
        mTextView.setTypeface(null, Typeface.NORMAL);
        mTextView.setText(mQuestionList.get(listPosition));
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandableListPositon) {

        return true;
    }

  @Override
    public int getChildType(int groupPosition, int childPosition) {
       //return groupPosition;
       return super.getChildType(groupPosition, childPosition);
    }
}


