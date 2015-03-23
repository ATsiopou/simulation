import java.util.Date;

import javax.swing.*;


public class TimePanel extends JPanel{
	
	private Date date=new Date();
    private JLabel hoursLabel=new JLabel("0");
    private JLabel minutesLabel=new JLabel("0");
    private int timeCounter=0;
    
	@SuppressWarnings("deprecation")
	public TimePanel(){
		date.setMinutes(0);
		date.setHours(0);

		this.add(hoursLabel, this);
		this.add(new JLabel(":"), this);
		this.add(minutesLabel, this);
		this.add(new JLabel("Sib City"), this);


		
	}
	
	public void workTimeTraffic(){

		if(timeCounter%240==0){
			changeTime();
			hoursLabel.setText(date.getMinutes()+"");

		}
	}
	
	
	@SuppressWarnings("deprecation")
	public void changeTime(){
		hoursLabel.setText("sa");

		if(date.getMinutes()==59){
			date.setMinutes(0);

			if(date.getHours()==23){
				date.setHours(0);

			}else{
				date.setHours(date.getHours()+1);

			}

		}else{
			date.setMinutes(date.getMinutes()+1);


		}
		
		
	}
	
	public void setTrafficByTime(int time){
//		if(time==7){
//			ENTRYFREQUENCY=TOTALNUMEROFCARS-2;
//			TOTALNUMEROFCARS=TOTALNUMEROFCARS+30;
//		}else if(time==9){
//			ENTRYFREQUENCY=TOTALNUMEROFCARS+2;
//			TOTALNUMEROFCARS=TOTALNUMEROFCARS-30;
//		}else if(time==15){
//			ENTRYFREQUENCY=TOTALNUMEROFCARS-2;
//			TOTALNUMEROFCARS=TOTALNUMEROFCARS+30;
//		}else if(time==17){
//			ENTRYFREQUENCY=TOTALNUMEROFCARS+2;
//			TOTALNUMEROFCARS=TOTALNUMEROFCARS-30;
//		}else if(time==20){
//			ENTRYFREQUENCY=TOTALNUMEROFCARS-2;
//			TOTALNUMEROFCARS=TOTALNUMEROFCARS+30;
//		}else if(time==0){
//			ENTRYFREQUENCY=TOTALNUMEROFCARS+2;
//			TOTALNUMEROFCARS=TOTALNUMEROFCARS-30;
//		}
//		
		
	}
	

}
