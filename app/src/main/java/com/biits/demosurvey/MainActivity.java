package com.biits.demosurvey;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;

import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.biits.demosurvey.DB.MarketResearchDatabaseOpenHelper;
import com.biits.demosurvey.Model.AnswerResponse;
import com.biits.demosurvey.Model.Question;
import com.biits.demosurvey.controller.AppConfig;
import com.biits.demosurvey.controller.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName();

    //Process Dialog
    private ProgressDialog pDialog;
    public Button Button_Submit;
    //SurveyQuestionList
    private ExpandableListView expandlistView;
    private Animation animationUp, animationDown;
    private List<Question> Questionlist = new ArrayList<>();
    QuestionAdapter questionListAdapter;
    ExpAdapter mExpAdapter;

    //Shared prefarence
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs";
    Button mButton;

    //Data source
    MarketResearchDatabaseOpenHelper dataSource;
    private int answerresponseIndex = 0;
    List<AnswerResponse> answerResponses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  mButton=(Button)findViewById(R.id.Button_Submit);
        //Open Database
        dataSource = new MarketResearchDatabaseOpenHelper(this);

        //shared prefarence
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        pDialog = new ProgressDialog(this);
        pDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        expandlistView = (ExpandableListView) findViewById(R.id.expandable_view);

        String Question_SurveyId = "e7bf3138-63fb-14e8-9cbc-bddcd52fd4b9";

        getAllQuestion(Question_SurveyId);

        InputMethodManager imm = (InputMethodManager) getApplicationContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        if (imm.isActive()) {
            mButton.setVisibility(View.INVISIBLE);
            //writeToLog("Software Keyboard was shown");
        } else {
            mButton.setVisibility(View.VISIBLE);
            // writeToLog("Software Keyboard was not shown");
        }
    }

    /**
     * Function to store user in MySQL database will post params(tag, Comapny ID ,
     */
    private void getAllQuestion(final String Question_SurveyId) {
        // Tag used to cancel the request
        String tag_string_req = "req_Question...";

        pDialog.setMessage("Retriving ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST, AppConfig.URL_SURVEY_QUESTION_LIST, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Retrive Response: " + response.toString());
                System.out.println("jsonArray" + response.toString());
                hideDialog();

                try {
                    // Parsing json array response
                    // loop through each json object

                    // Getting JSON Array node
                    JSONArray jsonArray = new JSONArray(response);

                    System.out.println("jsonArray" + jsonArray);


                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObjectquestion = (JSONObject) jsonArray.get(i);
                        Question question = new Question();
                        question.setQuestionno(jsonObjectquestion.getString("ques_no"));
                        question.setQuestion(jsonObjectquestion.getString("QuestionDisplay"));
                        question.setQuestiontype(jsonObjectquestion.getString("QuestionType"));
                        question.setQuestionId(jsonObjectquestion.getString("QuestionId"));


                        // Getting JSON Array node
                        JSONArray jsonArray_ans_option = jsonObjectquestion.getJSONArray("ans_option");


                        System.out.println("jsonArray_ans_option" + jsonArray_ans_option);

                        for (int j = 0; j < jsonArray_ans_option.length(); j++) {

                            if (jsonArray_ans_option.length() == 1) {
                                JSONObject jsonObjectoptionone = (JSONObject) jsonArray_ans_option.get(0);
                                question.setOptionone(jsonObjectoptionone.getString("AnswerOptions"));
                                question.setAnswerOptionsId1(jsonObjectoptionone.getString("AnswerOptionsId"));

                            }
                            if (jsonArray_ans_option.length() == 2) {
                                JSONObject jsonObjectoptionone = (JSONObject) jsonArray_ans_option.get(0);
                                question.setOptionone(jsonObjectoptionone.getString("AnswerOptions"));
                                question.setAnswerOptionsId1(jsonObjectoptionone.getString("AnswerOptionsId"));

                                JSONObject jsonObjectoptiontwo = (JSONObject) jsonArray_ans_option.get(1);
                                question.setOptiontwo(jsonObjectoptiontwo.getString("AnswerOptions"));
                                question.setAnswerOptionsId2(jsonObjectoptiontwo.getString("AnswerOptionsId"));

                            }
                            if (jsonArray_ans_option.length() == 3) {
                                JSONObject jsonObjectoptionone = (JSONObject) jsonArray_ans_option.get(0);
                                question.setOptionone(jsonObjectoptionone.getString("AnswerOptions"));
                                question.setAnswerOptionsId1(jsonObjectoptionone.getString("AnswerOptionsId"));

                                JSONObject jsonObjectoptiontwo = (JSONObject) jsonArray_ans_option.get(1);
                                question.setOptiontwo(jsonObjectoptiontwo.getString("AnswerOptions"));
                                question.setAnswerOptionsId2(jsonObjectoptiontwo.getString("AnswerOptionsId"));

                                JSONObject jsonObjectoptionthree = (JSONObject) jsonArray_ans_option.get(2);
                                question.setOptionthree(jsonObjectoptionthree.getString("AnswerOptions"));
                                question.setAnswerOptionsId3(jsonObjectoptionthree.getString("AnswerOptionsId"));

                            }
                            if (jsonArray_ans_option.length() == 4) {
                                JSONObject jsonObjectoptionone = (JSONObject) jsonArray_ans_option.get(0);
                                question.setOptionone(jsonObjectoptionone.getString("AnswerOptions"));
                                question.setAnswerOptionsId1(jsonObjectoptionone.getString("AnswerOptionsId"));

                                JSONObject jsonObjectoptiontwo = (JSONObject) jsonArray_ans_option.get(1);
                                question.setOptiontwo(jsonObjectoptiontwo.getString("AnswerOptions"));
                                question.setAnswerOptionsId2(jsonObjectoptiontwo.getString("AnswerOptionsId"));

                                JSONObject jsonObjectoptionthree = (JSONObject) jsonArray_ans_option.get(2);
                                question.setOptionthree(jsonObjectoptionthree.getString("AnswerOptions"));
                                question.setAnswerOptionsId3(jsonObjectoptionthree.getString("AnswerOptionsId"));

                                JSONObject jsonObjectoptionfour = (JSONObject) jsonArray_ans_option.get(3);
                                question.setOptionfour(jsonObjectoptionfour.getString("AnswerOptions"));
                                question.setAnswerOptionsId4(jsonObjectoptionfour.getString("AnswerOptionsId"));

                            }


                        }

                        Questionlist.add(question);


                    }
                    mExpAdapter = new ExpAdapter(getApplicationContext(), Questionlist);
                    expandlistView.setAdapter(mExpAdapter);
                    expandlistView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
                        int previousGroup = -1;
                        boolean flag = false;

                        @Override
                        public void onGroupExpand(int groupPosition) {

                            if (groupPosition != previousGroup && flag) {
                                expandlistView.collapseGroup(previousGroup);
                            }
                            previousGroup = groupPosition;
                            flag = true;
                        }
                    });
                    expandlistView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                        @Override
                        public boolean onChildClick(ExpandableListView expandableListView, View view,final int groupPosition, final int childPosition, long l) {
                      /*  final int index=expandableListView.getFlatListPosition(ExpandableListView.getPackedPositionForChild(groupPosition,childPosition));
                        expandableListView.setItemChecked(index,true);
                        expandableListView.setSelectedChild(groupPosition,childPosition,true);
                        expandableListView.getChildAt(index);*/

                            return false;
                        }
                    });
                    expandlistView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                        @Override
                        public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
                            expandableListView.collapseGroup(groupPosition);
                   //         mExpAdapter.notifyDataSetChanged();
                            return false;
                        }
                    });


                    expandlistView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                        @Override
                        public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {

                            return false;
                        }
                    });

                    findViewById(R.id.Button_Submit).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String message = "";
                            for (int i = 0; i < mExpAdapter.selectedAnswers.size(); i++) {
                                message = message + "\n" + (i + 1) + " " + mExpAdapter.selectedAnswers.get(i);
                            }
                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                            Log.d(MainActivity.class.getSimpleName().toString(),message);

                        }
                    });


                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Retriving Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to retrive url
                Map<String, String> params = new HashMap<String, String>();
                params.put("Question_SurveyId", Question_SurveyId);

                return params;
            }

        };
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void showDialog() {
        if (!pDialog.isShowing()) pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing()) pDialog.dismiss();
    }
/*
    //Hide KeyBoard
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }*/


    // Adapter for Question

    public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.MyViewHolder> {

        private LayoutInflater layoutInflater;
        private Animation animationUp, animationDown;
        List<Question> questionList;
        Context mContext;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView Textview_questionnumber, Textview_question, Textview_QuestionId, Textview_OPtionID;
            public RadioButton radio_optionid1, radio_optionid2, radio_optionid3, radio_optionid4;
            public LinearLayout Linear_question, Liner_option, Liner_single, Liner_multiple, Liner_comments;
            public RadioButton radio_option1, radio_option2, radio_option3, radio_option4;
            public CheckBox checkbox_option1, checkbox_option2, checkbox_option3, checkbox_option4, checkBox;
            public EditText EditText_comments;
            public RadioGroup radioGroup_single, radioGroup_optionid;

            public MyViewHolder(View view) {
                super(view);

                Textview_questionnumber = (TextView) view.findViewById(R.id.Textview_questionnumber);
                Textview_question = (TextView) view.findViewById(R.id.Textview_question);

                Textview_QuestionId = (TextView) view.findViewById(R.id.Textview_QuestionId);
                Textview_OPtionID = (TextView) view.findViewById(R.id.Textview_OPtionID);

                radio_optionid1 = (RadioButton) view.findViewById(R.id.radio_optionid1);
                radio_optionid2 = (RadioButton) view.findViewById(R.id.radio_optionid2);
                radio_optionid3 = (RadioButton) view.findViewById(R.id.radio_optionid3);
                radio_optionid4 = (RadioButton) view.findViewById(R.id.radio_optionid4);

                EditText_comments = (EditText) view.findViewById(R.id.EditText_comments);

                radioGroup_single = (RadioGroup) view.findViewById(R.id.radioGroup_single);
                radioGroup_optionid = (RadioGroup) view.findViewById(R.id.radioGroup_optionid);

                radio_option1 = (RadioButton) view.findViewById(R.id.radio_option1);
                radio_option2 = (RadioButton) view.findViewById(R.id.radio_option2);
                radio_option3 = (RadioButton) view.findViewById(R.id.radio_option3);
                radio_option4 = (RadioButton) view.findViewById(R.id.radio_option4);

                checkbox_option1 = (CheckBox) view.findViewById(R.id.checkbox_option1);
                checkbox_option2 = (CheckBox) view.findViewById(R.id.checkbox_option2);
                checkbox_option3 = (CheckBox) view.findViewById(R.id.checkbox_option3);
                checkbox_option4 = (CheckBox) view.findViewById(R.id.checkbox_option4);

                Liner_single = (LinearLayout) view.findViewById(R.id.Liner_single);
                Liner_multiple = (LinearLayout) view.findViewById(R.id.Liner_multiple);
                Liner_comments = (LinearLayout) view.findViewById(R.id.Liner_comments);
                Linear_question = (LinearLayout) view.findViewById(R.id.Linear_question);
                Liner_option = (LinearLayout) view.findViewById(R.id.Liner_option);

            }

            public void bind(Question question) {

                Textview_question.setText(question.getQuestion());
            }
        }


        public QuestionAdapter(Context context, Animation animationUp, Animation animationDown, List<Question> questionList) {
            this.questionList = questionList;
            this.mContext = context;
            this.layoutInflater = LayoutInflater.from(context);
            this.animationDown = animationDown;
            this.animationUp = animationUp;
        }


        public QuestionAdapter(Context applicationContext, List<Question> questionList) {
            this.questionList = questionList;

        }

        @Override
        public QuestionAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question_row, parent, false);

            return new QuestionAdapter.MyViewHolder(itemView);


        }

        @Override
        public void onBindViewHolder(final QuestionAdapter.MyViewHolder holder, final int position) {

            final Question question = questionList.get(position);


            //  public TextView pujaid,title, description, map, address,image, contact;
            // public ImageView thumbnail;

            holder.Textview_questionnumber.setText(question.getQuestionno());
            holder.Textview_question.setText(question.getQuestion());

            holder.Textview_QuestionId.setText(question.getQuestionId());


            String questiontype = question.getQuestiontype();
            if (questiontype.equals("option")) {


                holder.Liner_single.setVisibility(View.VISIBLE);
                holder.Liner_multiple.setVisibility(View.GONE);
                holder.Liner_comments.setVisibility(View.GONE);

                holder.radio_option1.setText(question.getOptionone());
                holder.radio_option2.setText(question.getOptiontwo());
                holder.radio_option3.setText(question.getOptionthree());
                holder.radio_option4.setText(question.getOptionfour());

                holder.radio_optionid1.setText(question.getAnswerOptionsId1());
                holder.radio_optionid2.setText(question.getAnswerOptionsId2());
                holder.radio_optionid3.setText(question.getAnswerOptionsId3());
                holder.radio_optionid4.setText(question.getAnswerOptionsId4());

                if (question.getOptionone() != null) {
                    holder.radio_option1.setVisibility(View.VISIBLE);

                } else {
                    holder.Liner_option.setVisibility(View.GONE);
                    questionListAdapter.notifyDataSetChanged();
                }
                if (question.getOptiontwo() != null)
                    holder.radio_option2.setVisibility(View.VISIBLE);

                if (question.getOptionthree() != null)
                    holder.radio_option3.setVisibility(View.VISIBLE);

                if (question.getOptionfour() != null)
                    holder.radio_option4.setVisibility(View.VISIBLE);


            } else if (questiontype.equalsIgnoreCase("comment")) {


                holder.Liner_single.setVisibility(View.GONE);
                holder.Liner_multiple.setVisibility(View.GONE);
                holder.Liner_comments.setVisibility(View.VISIBLE);

                String answer = holder.EditText_comments.getText().toString();

            } else {
                holder.Liner_single.setVisibility(View.GONE);
                holder.Liner_multiple.setVisibility(View.VISIBLE);
                holder.Liner_comments.setVisibility(View.GONE);


                holder.checkbox_option1.setText(question.getOptionone());
                holder.checkbox_option2.setText(question.getOptiontwo());
                holder.checkbox_option3.setText(question.getOptionthree());
                holder.checkbox_option4.setText(question.getOptionfour());


                if (question.getOptionone() != null)
                    holder.checkbox_option1.setVisibility(View.VISIBLE);

                if (question.getOptiontwo() != null)
                    holder.checkbox_option2.setVisibility(View.VISIBLE);

                if (question.getOptionthree() != null)
                    holder.checkbox_option3.setVisibility(View.VISIBLE);

                if (question.getOptionfour() != null)
                    holder.checkbox_option4.setVisibility(View.VISIBLE);
            }


            holder.itemView.setTag(holder);


           /* holder.EditText_comments.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        hideKeyboard(v);
                    }
                }
            });*/


            //ON click Listener of card item
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (holder.Liner_option.isShown()) {

                        String questiondisplay = question.getQuestion();
                        String QuestionID = question.getQuestionId();
                        String QuestionNO = question.getQuestionno();

                        if (holder.radio_option1.isChecked()) {
                            holder.radio_optionid1.setChecked(true);
                        }
                        if (holder.radio_option2.isChecked()) {
                            holder.radio_optionid2.setChecked(true);
                        }
                        if (holder.radio_option3.isChecked()) {
                            holder.radio_optionid3.setChecked(true);
                        }
                        if (holder.radio_option4.isChecked()) {
                            holder.radio_optionid4.setChecked(true);
                        }


                        //get Shared prefarence
                        SharedPreferences prefs = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
                        final Long AnswerResponseId = prefs.getLong("AnswerResponseId", 0);
                        final String AnswerResponse_AnswerOptionsId = prefs.getString("AnswerResponse_AnswerOptionsId", null);
                        final String AnswerResponse_QuestionId = prefs.getString("AnswerResponse_QuestionId", null);
                        final String AnswerResponseDescription = prefs.getString("AnswerResponseDescription", null);
                        //final String UserId = prefs.getString("UserId", null);


                        final String UserId = "5b2a4e7e199166.31869108";


                        // System.out.println("answerUserId"+UserId);


                        //Radio button group
                        int selectedId = holder.radioGroup_single.getCheckedRadioButtonId();
                        int selectedoptionId = holder.radioGroup_optionid.getCheckedRadioButtonId();

                        // find the radio button by returned id
                        RadioButton radioButton = (RadioButton) view.findViewById(selectedId);
                        RadioButton radio_OptionId = (RadioButton) view.findViewById(selectedoptionId);


                        //Get the value from Radio group

                        String radiovalue = String.valueOf(selectedId);
                        System.out.println("selectedoptionId" + String.valueOf(selectedoptionId));
                        if (radiovalue != "-1") {
                            //   Toast.makeText(view.getContext(),radioButton.getText()+""+QuestionID+""+radioButton1.getText()+questiondisplay, Toast.LENGTH_SHORT).show();

                            Toast.makeText(view.getContext(), radio_OptionId.getText() + "" + QuestionID + "" + radioButton.getText() + UserId, Toast.LENGTH_SHORT).show();

                            if (AnswerResponse_QuestionId == null) {

                                //Store Data  in local DB
                                boolean isInserted = dataSource.insertData(radio_OptionId.getText().toString(), QuestionID, radioButton.getText().toString(), "5b2a4e7e199166.31869108", 1);


                                if (isInserted == true) {
                                    Log.d(TAG, "Submit: " + isInserted);
                                    Toast.makeText(view.getContext(), radio_OptionId.getText() + "" + QuestionID + "" + radioButton.getText() + UserId, Toast.LENGTH_SHORT).show();

                                }

                            }


                        }


                        //get The comments value
                        String commentsvalue = holder.EditText_comments.getText().toString();


                        holder.EditText_comments.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                holder.EditText_comments.setText(s.toString());
                            }

                            @Override
                            public void afterTextChanged(Editable s) {
                                holder.EditText_comments.setSelection(holder.EditText_comments.getText().length());
                            }
                        });


                        if (!commentsvalue.isEmpty()) {
                            holder.radio_optionid1.setChecked(true);

                            holder.Textview_OPtionID.setText(question.getAnswerOptionsId1());
                            //  holder.radio_optionid1.setChecked(true);
                            if (AnswerResponse_QuestionId == null) {

                                //Store Data  in local DB
                                boolean isInserted = dataSource.insertData(holder.Textview_OPtionID.getText().toString(), QuestionID, holder.EditText_comments.getText().toString(), "5b2a4e7e199166.31869108", 1);

                                if (isInserted == true) {
                                    Log.d(TAG, "Submit: " + isInserted);
                                    Toast.makeText(view.getContext(), holder.Textview_OPtionID.getText().toString() + "" + QuestionID + "" + holder.EditText_comments.getText().toString() + UserId, Toast.LENGTH_SHORT).show();

                                }
                            }

//                            else{
//                                //Update into DBS
//                                String regid = Long.toString(AnswerResponseId);
//                                boolean isUpdate = dataSource.updateData(regid,holder.Textview_OPtionID.getText().toString(),
//                                        QuestionID,
//                                        holder.EditText_comments.getText().toString() );
//                                if(isUpdate == true) {
//                                    Log.d(TAG, "Submit: " + isUpdate);
//
//                                }
//                            }


                        }


                        //get the check box value
                        String checkboxresult = "";
                        if (holder.checkbox_option1.isChecked()) {

                            String finalresult = question.getOptionone();
                            checkboxresult += "\n" + finalresult;
                        }
                        if (holder.checkbox_option2.isChecked()) {

                            String finalresult = question.getOptiontwo();
                            checkboxresult += "\n" + finalresult;

                        }
                        if (holder.checkbox_option3.isChecked()) {

                            String finalresult = question.getOptionthree();
                            checkboxresult += "\n" + finalresult;

                        }
                        if (holder.checkbox_option4.isChecked()) {

                            String finalresult = question.getOptionfour();
                            checkboxresult += "\n" + finalresult;

                        }

                        if (!checkboxresult.isEmpty()) {
                            //  Toast.makeText(view.getContext(),""+checkboxresult+questiondisplay,Toast.LENGTH_LONG).show();
                        }


                        holder.Liner_option.setVisibility(View.GONE);
//               Toast.makeText(view.getContext(),"CLICK working"+finalcheckresult,Toast.LENGTH_LONG).show();


                    } else {
                        holder.Liner_option.setVisibility(View.VISIBLE);

                        /*if (holder.Liner_option.isShown()){
                            holder.itemView.animate();
                            holder.Liner_option.setVisibility(View.GONE);
                            questionListAdapter.notifyDataSetChanged();

                        }*/

                        String QuestionID = question.getQuestionId();
                        //get the  details from the DB.
                        answerResponses = dataSource.getAnswerResponse(QuestionID);

                        System.out.println("answerResponses" + answerResponses);
                        if (answerResponses.size() > 0) {
                            Long AnswerResponseId = answerResponses.get(answerresponseIndex).getAnswerResponseId();
                            String AnswerResponse_AnswerOptionsId = answerResponses.get(answerresponseIndex).getAnswerResponse_AnswerOptionsId();
                            String AnswerResponse_QuestionId = answerResponses.get(answerresponseIndex).getAnswerResponse_QuestionId();
                            String AnswerResponseDescription = answerResponses.get(answerresponseIndex).getAnswerResponseDescription();


                            if (AnswerResponse_QuestionId != null) {

                                //  sharedpreferences.Editor editor = sharedpreferences.edit();
                                SharedPreferences.Editor editor = sharedpreferences.edit();
                                editor.putLong("AnswerResponseId", AnswerResponseId);
                                editor.putString("AnswerResponse_AnswerOptionsId", AnswerResponse_AnswerOptionsId);
                                editor.putString("AnswerResponse_QuestionId", AnswerResponse_QuestionId);
                                editor.putString("AnswerResponseDescription", AnswerResponseDescription);
                                editor.commit();


                                // Toast.makeText(getApplicationContext(),AnswerResponse_QuestionId,Toast.LENGTH_LONG).show();
                            }
                        }

                    }


                }
            });
        }


        @Override
        public int getItemCount() {
            return questionList.size();
        }


    }
}
