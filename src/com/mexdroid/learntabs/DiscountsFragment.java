package com.mexdroid.learntabs;
import java.text.NumberFormat;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class DiscountsFragment extends Fragment  {

	// Declare variables
    EditText  etPrice; 
	EditText  etDiscount;
	TextView tvDiscountedPrice;
	Button btnCalculate;
	 
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.discounts, container, false);
                
        //find views
    
	    btnCalculate = (Button) rootView.findViewById(R.id.btnCalculate);
        etPrice = (EditText) rootView.findViewById(R.id.etPrice);
	    etDiscount = (EditText) rootView.findViewById(R.id.etDiscount);
	    tvDiscountedPrice = (TextView) rootView.findViewById(R.id.tvDiscountedPrice);
		
	    //set filters to allow no more than two decimals
	    etPrice.setFilters(new InputFilter[] {new MoneyValueFilter()});
	    
        
        //set a listener
        btnCalculate.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				calculateDiscount();
			}
		});
         
        return rootView;
    }	
	
	public void calculateDiscount() {
		
		
		float price = 0;
		int discountPercentage = 0;
		float discount = 0;
		float finalprice = 0 ;
	    
		NumberFormat format = NumberFormat.getCurrencyInstance();
		
    
		// Read values and cast to float & integer
	    price = Float.parseFloat(etPrice.getText().toString());
	    discountPercentage = Integer.valueOf(etDiscount.getText().toString());

  	    // Calculate Discount by user given data
	    
	    discount = 1 - (float) discountPercentage / 100;
	    finalprice = price * discount;
	    
	    	    
	    // Display result formatted according to the local currency of the device
	    tvDiscountedPrice.setText(format.format(finalprice));
	    		
	}
	
	
}
