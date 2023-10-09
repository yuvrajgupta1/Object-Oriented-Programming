import canadian.payroll.TaxCategory;
import canadian.payroll.GovernmentTax;
import canadian.payroll.Employee;
import canadian.payroll.EI;
import canadian.payroll.CPP;
import canadian.payroll.HealthPremium;
import canadian.Utility;
import canadian.file.CSVReader;
import canadian.DataScience;
import java.util.*;

public class QualityAssurance {
	static Map<Integer, Employee> map;
	//This question is worth 20 points
	public static boolean[] Q1() {

		boolean [] answer = new boolean[5];
		//Testing the categories for Alberta
		Map<Integer, TaxCategory> alberta = new GovernmentTax.TaxUtil().alberta();
		if( alberta != null ) {

			//case 1
			TaxCategory cat = alberta.get(1);
			answer[0] = checkCategory( cat, 10, 0, 131220 );
			//case 2
			cat = alberta.get(2);
			answer[1] = checkCategory( cat, 12, 131220.01, 157464 );
			//case 3
			cat = alberta.get(3);
			answer[2] = checkCategory( cat, 13, 157464.01, 209952 );
			//case 4
			cat = alberta.get(4);
			answer[3] = checkCategory( cat, 14, 209952.01, 314928 );
			cat = alberta.get(5);
			answer[4] = checkCategory( cat, 15, 314928.01, 10000000 );
		}
		return answer;	
	}

	public static boolean[] Q2() {

		boolean [] answer = new boolean[7];
		//Testing the categories for British Columbia
		Map<Integer, TaxCategory> bc = new GovernmentTax.TaxUtil().britishColumbia();
		if( bc != null ) {

			//case 1
			TaxCategory cat = bc.get(1);

			answer[0] = checkCategory( cat, 5.06, 0, 42184 );
			//case 2
			cat = bc.get(2);
			answer[1] = checkCategory( cat, 7.7, 42184.01, 84369 );
			//case 3
			cat = bc.get(3);
			answer[2] = checkCategory( cat, 10.5, 84369.01, 96866 );
			//case 4
			cat = bc.get(4);
			answer[3] = checkCategory( cat, 12.29, 96866.01, 117623 );
			cat = bc.get(5);
			answer[4] = checkCategory( cat, 14.7, 117623.01, 159483 );
			cat = bc.get(6);
			answer[5] = checkCategory( cat, 16.8, 159483.01, 222420 );
			cat = bc.get(7);
			answer[6] = checkCategory( cat, 20.5, 222420.01, 10000000 );	
		}
		return answer;	
	}

	public static boolean[] Q3() {

		boolean [] answer = new boolean[5];
		//Testing the categories for New Brunswick
		Map<Integer, TaxCategory> nb = new GovernmentTax.TaxUtil().newBrunswick();
		if( nb != null ) {

			//case 1
			TaxCategory cat = nb.get(1);
			answer[0] = checkCategory( cat, 9.68, 0, 43835 );
			//case 2
			cat = nb.get(2);
			answer[1] = checkCategory( cat, 14.82, 43835.01, 87671 );
			//case 3
			cat = nb.get(3);
			answer[2] = checkCategory( cat, 16.52, 87671.01, 142534 );
			//case 4
			cat = nb.get(4);
			answer[3] = checkCategory( cat, 17.84, 142534.01, 162383 );
			cat = nb.get(5);
			answer[4] = checkCategory( cat, 20.3, 162383.01, 10000000 );
		}
		return answer;	
	}

	public static boolean[] Q4() {

		boolean [] answer = new boolean[5];
		//Testing the categories for Nova Scotia
		Map<Integer, TaxCategory> tax = new GovernmentTax.TaxUtil().novaScotia();
		if( tax != null ) {

			//case 1
			TaxCategory cat = tax.get(1);
			answer[0] = checkCategory( cat, 8.79, 0, 29590 );
			//case 2
			cat = tax.get(2);
			answer[1] = checkCategory( cat, 14.95, 29590.01, 59180 );
			//case 3
			cat = tax.get(3);
			answer[2] = checkCategory( cat, 16.67, 59180.01, 93000 );
			//case 4
			cat = tax.get(4);
			answer[3] = checkCategory( cat, 17.5, 93000.01, 150000 );
			cat = tax.get(5);
			answer[4] = checkCategory( cat, 21.0, 150000.01, 10000000 );
		}
		return answer;	
	}

	public static boolean[] Q5() {

		boolean [] answer = new boolean[5];
		//Testing the categories for Ontario
		Map<Integer, TaxCategory> tax = new GovernmentTax.TaxUtil().ontario();
		if( tax != null ) {

			//case 1
			TaxCategory cat = tax.get(1);
			answer[0] = checkCategory( cat, 5.05, 0, 44740 );
			//case 2
			cat = tax.get(2);
			answer[1] = checkCategory( cat, 9.15, 44740.01, 89482 );
			//case 3
			cat = tax.get(3);
			answer[2] = checkCategory( cat, 11.16, 89482.01, 150000 );
			//case 4
			cat = tax.get(4);
			answer[3] = checkCategory( cat, 12.16, 150000.01, 220000 );
			cat = tax.get(5);
			answer[4] = checkCategory( cat, 13.16, 220000.01, 10000000 );
		}
		return answer;	
	}

	public static boolean[] Q6() {

		boolean [] answer = new boolean[3];
		//Testing the categories for Saskatchewan
		Map<Integer, TaxCategory> tax = new GovernmentTax.TaxUtil().saskatchewan();
		if( tax != null ) {

			//case 1
			TaxCategory cat = tax.get(1);
			answer[0] = checkCategory( cat, 10.5, 0, 45677 );
			//System.out.println(answer[0]);
			//case 2
			cat = tax.get(2);
			answer[1] = checkCategory( cat, 12.5, 45677.01, 130506 );
			//System.out.println(answer[1]);
			//case 3
			cat = tax.get(3);
			answer[2] = checkCategory( cat, 13.16, 130506.01, 10000000 );
			//System.out.println(answer[2]);
		}
		return answer;	
	}

	public static boolean[] Q7() {

		boolean [] answer = new boolean[5];
		//Testing the categories for federal
		Map<Integer, TaxCategory> tax = new GovernmentTax.TaxUtil().federal();
		if( tax != null ) {

			//case 1
			TaxCategory cat = tax.get(1);
			answer[0] = checkCategory( cat, 15, 0, 49020);
			//System.out.println(answer[0]);
			//case 2
			cat = tax.get(2);
			answer[1] = checkCategory( cat, 20.5, 49020.01, 98040 );
			//System.out.println(answer[1]);
			//case 3
			cat = tax.get(3);
			answer[2] = checkCategory( cat, 26, 98040.01, 151978 );
			//System.out.println(answer[2]);
			cat = tax.get(4);
			answer[3] = checkCategory( cat, 29, 151978.01, 216511 );
			//System.out.println(answer[3]);
			cat = tax.get(5);
			answer[4] = checkCategory( cat, 33, 216511.01, 10000000 );
			//System.out.println(answer[4]);
		}
		return answer;	
	}

	public static boolean[] Q8() {

		boolean [] answer = new boolean[1];
		
		//Testing provincial tax for Alberta
		Employee employee = new Employee();
		employee.setIncome(93230);
		employee.setProvince("alberta");
		GovernmentTax tax = new GovernmentTax( employee, employee.getProvince() );
		answer[0] = ( tax.getAmount() == 9323 );
		return answer;	
	}

	public static boolean[] Q9() {

		boolean [] answer = new boolean[1];
		
		///Testing provincial tax for British Columbia
		Employee employee = new Employee();
		employee.setIncome(93230);
		employee.setProvince("bc");
		GovernmentTax tax = new GovernmentTax( employee, employee.getProvince() );
		answer[0] = ( tax.getAmount() == 6313.16 );
		return answer;	
	}

	public static boolean[] Q10() {

		boolean [] answer = new boolean[1];
		
		//Testing provincial tax for Manitoba
		Employee employee = new Employee();
		employee.setIncome(93230);
		employee.setProvince("mb");
		GovernmentTax tax = new GovernmentTax( employee, employee.getProvince() );
		answer[0] = ( tax.getAmount() == 12175.27 );
		return answer;	
	}

	public static boolean[] Q11() {

		boolean [] answer = new boolean[1];
		
		//Testing provincial tax for New Brunswick
		Employee employee = new Employee();
		employee.setIncome(93230);
		employee.setProvince("nb");
		GovernmentTax tax = new GovernmentTax( employee, employee.getProvince() );
		answer[0] = ( tax.getAmount() == 11658.07 );
		return answer;	
	}

	public static boolean[] Q12() {

		boolean [] answer = new boolean[1];
		
		//Testing provincial tax for Nova Scotia
		Employee employee = new Employee();
		employee.setIncome(93230);
		employee.setProvince("ns");
		GovernmentTax tax = new GovernmentTax( employee, employee.getProvince() );
		answer[0] = ( tax.getAmount() == 12702.71 );
		return answer;	
	}

	public static boolean[] Q13() {

		boolean [] answer = new boolean[1];
		
		//Testing provincial tax for Ontario
		Employee employee = new Employee();
		employee.setIncome(93230);
		employee.setProvince("on");
		GovernmentTax tax = new GovernmentTax( employee, employee.getProvince() );
		answer[0] = ( tax.getAmount() == 6771.54 );
		return answer;	
	}

	public static boolean[] Q14() {

		boolean [] answer = new boolean[1];
		
		//Testing provincial tax for Saskatchewan
		Employee employee = new Employee();
		employee.setIncome(93230);
		employee.setProvince("sk");
		GovernmentTax tax = new GovernmentTax( employee, employee.getProvince() );
		answer[0] = ( tax.getAmount() == 10740.21 );
		return answer;	
	}

	public static boolean[] Q15() {

		boolean [] answer = new boolean[1];
		
		//Testing federal tax
		Employee employee = new Employee();
		employee.setIncome(93230);
		employee.setProvince("federal");
		GovernmentTax tax = new GovernmentTax( employee, employee.getProvince() );
		answer[0] = ( tax.getAmount() == 16416.05 );
		return answer;	
	}

	public static boolean[] Q16() {

		//Testing the computations of EI - Employment Insurance
		boolean [] answer = new boolean[1];
		boolean ans = true;
		Employee employee = new Employee();
		employee.setIncome(2000);
		EI ei = new EI( employee );
		ans = ( ei.getAmount() == 31.6 );
		employee.setIncome(10000);
		ans = ans && ( ei.getAmount() == 158 );
		employee.setIncome(50000);
		ans = ans && ( ei.getAmount() == 790 );
		employee.setIncome(200000);
		ans = ans && ( ei.getAmount() == 856.36 );

		answer[0] = ans;
		return answer;	
	}

	public static boolean[] Q17() {

		//Testing the computations of CPP - Canadian Pension Plan
		boolean [] answer = new boolean[1];
		boolean ans = true;
		Employee employee = new Employee();
		employee.setIncome(2000);
		CPP cpp = new CPP( employee );
		ans = ( cpp.getAmount() == 105 );
		employee.setIncome(10000);
		ans = ans && ( cpp.getAmount() == 525 );
		employee.setIncome(50000);
		ans = ans && ( cpp.getAmount() == 2625 );
		employee.setIncome(200000);
		ans = ans && ( cpp.getAmount() == 2898 );

		answer[0] = ans;
		return answer;	
	}

	public static boolean[] Q18() {

		//Testing the computations of Health Premium
		boolean [] answer = new boolean[1];
		boolean ans = true;
		Employee employee = new Employee();
		employee.setIncome(20000);
		HealthPremium hp = new HealthPremium( employee );
		ans = ( hp.getAmount() == 0 );
		employee.setIncome(21000);
		ans = ans && ( hp.getAmount() == 0 );
		employee.setIncome(36000);
		ans = ans && ( hp.getAmount() == 300 );
		employee.setIncome(37000);
		ans = ans && ( hp.getAmount() == 300 );
		employee.setIncome(48000);
		ans = ans && ( hp.getAmount() == 450 );
		employee.setIncome(48500);
		ans = ans && ( hp.getAmount() == 450 );
		employee.setIncome(72000);
		ans = ans && ( hp.getAmount() == 600 );
		employee.setIncome(72500);
		ans = ans && ( hp.getAmount() == 600 );
		employee.setIncome(200000);
		ans = ans && ( hp.getAmount() == 750 );
		employee.setIncome(200500);
		ans = ans && ( hp.getAmount() == 750 );
		employee.setIncome(500000);
		ans = ans && ( hp.getAmount() == 900 );
		answer[0] = ans;
		return answer;	
	}

	public static boolean[] Q19() {

		//Testing the computations of Least Paid Employees
		boolean [] answer = new boolean[1];
		boolean ans = false;


		String fileName = "salaries.csv";
		map = CSVReader.getEmployees( fileName );
		Employee ab = DataScience.leastPaidEmployee( "alberta", map ),
			abb = new Employee();
			abb.setSerialNumber(9147);
			abb.setName("Kuzante Marandinho");
			abb.setSex("M");
			abb.setDob("24-02-95934");
			abb.setMaritalStatus("Divorced");
			abb.setProvince("AB");
			abb.setIncome(39649);
			abb.setDeductions( Utility.computeDeductions( abb ) );

		//You are to uncomment the following statement and other statements of this kind.
		ans = ab.equals( abb );


		Employee bc = DataScience.leastPaidEmployee( "bc", map ),
			bcc = new Employee();
			bcc.setSerialNumber(5563);
			bcc.setName("Kuzante Marandinho");
			bcc.setSex("M");
			bcc.setDob("24-02-43934");
			bcc.setMaritalStatus("Single");
			bcc.setProvince("BC");
			bcc.setIncome(13704);
			bcc.setDeductions( Utility.computeDeductions( bcc ) );

		ans = ans && bc.equals( bcc );

		

		Employee mb = DataScience.leastPaidEmployee( "mb", map ),
			mbb = new Employee();
			mbb.setSerialNumber(6063);
			mbb.setName("Kuzante Marandinho");
			mbb.setSex("M");
			mbb.setDob("24-02-43934");
			mbb.setMaritalStatus("Single");
			mbb.setProvince("MB");
			mbb.setIncome(13704);
			mbb.setDeductions( Utility.computeDeductions( mbb ) );

		ans = ans && mb.equals( mbb );

		Employee ns = DataScience.leastPaidEmployee( "ns", map ),
			nss = new Employee();
			nss.setSerialNumber(3053);
			nss.setName("Kuzante Marandinho");
			nss.setSex("M");
			nss.setDob("24-02-43934");
			nss.setMaritalStatus("Single");
			nss.setProvince("NS");
			nss.setIncome(13704);
			nss.setDeductions( Utility.computeDeductions( nss ) );

		ans = ans && ns.equals( nss );


		Employee nb = DataScience.leastPaidEmployee( "nb", map ),
			nbb = new Employee();
			nbb.setSerialNumber(5019);
			nbb.setName("Kuzante Marandinho");
			nbb.setSex("M");
			nbb.setDob("24-02-43934");
			nbb.setMaritalStatus("Single");
			nbb.setProvince("NB");
			nbb.setIncome(13704);
			nbb.setDeductions( Utility.computeDeductions( nbb ) );

		ans = ans && nb.equals( nbb );

		

		Employee sk = DataScience.leastPaidEmployee( "sk", map ),
			skk = new Employee();
			skk.setSerialNumber(5863);
			skk.setName("Kuzante Marandinho");
			skk.setSex("M");
			skk.setDob("24-02-43934");
			skk.setMaritalStatus("Single");
			skk.setProvince("SK");
			skk.setIncome(13704);
			skk.setDeductions( Utility.computeDeductions( skk ) );

		ans = ans && sk.equals( skk );

		Employee on = DataScience.leastPaidEmployee( "on", map ),
			onn = new Employee();
			onn.setSerialNumber(5963);
			onn.setName("Kuzante Marandinho");
			onn.setSex("M");
			onn.setDob("24-02-43934");
			onn.setMaritalStatus("Single");
			onn.setProvince("ON");
			onn.setIncome(13704);
			onn.setDeductions( Utility.computeDeductions( onn ) );

		ans = ans && on.equals( onn );		

		answer[0] = ans;
		return answer;	
	}

	public static boolean[] Q20() {

		//Testing the computations of Highest Paid Employees
		boolean [] answer = new boolean[1];
		boolean ans = false;


		String fileName = "salaries.csv";
		map = CSVReader.getEmployees( fileName );
		Employee ab = DataScience.highestPaidEmployee( "alberta", map ),
			abb = new Employee();
			abb.setSerialNumber(9136);
			abb.setName("Maruanto Mazindara");
			abb.setSex("N");
			abb.setDob("24-02-84934");
			abb.setMaritalStatus("Married");
			abb.setProvince("AB");
			abb.setIncome(231194);
			abb.setDeductions( Utility.computeDeductions( abb ) );

		ans = ab.equals( abb );

		Employee bc = DataScience.highestPaidEmployee( "bc", map ),
			bcc = new Employee();
			bcc.setSerialNumber(5562);
			bcc.setName("Maruanto Mazindara");
			bcc.setSex("N");
			bcc.setDob("24-02-42934");
			bcc.setMaritalStatus("Divorced");
			bcc.setProvince("BC");
			bcc.setIncome(249744);
			bcc.setDeductions( Utility.computeDeductions( bcc ) );

		ans = ans && bc.equals( bcc );		

		Employee mb = DataScience.highestPaidEmployee( "mb", map ),
			mbb = new Employee();
			mbb.setSerialNumber(6062);
			mbb.setName("Maruanto Mazindara");
			mbb.setSex("N");
			mbb.setDob("24-02-42934");
			mbb.setMaritalStatus("Divorced");
			mbb.setProvince("MB");
			mbb.setIncome(249744);
			mbb.setDeductions( Utility.computeDeductions( mbb ) );

		ans = ans && mb.equals( mbb );

		Employee ns = DataScience.highestPaidEmployee( "ns", map ),
			nss = new Employee();
			nss.setSerialNumber(3052);
			nss.setName("Maruanto Mazindara");
			nss.setSex("N");
			nss.setDob("24-02-42934");
			nss.setMaritalStatus("Divorced");
			nss.setProvince("NS");
			nss.setIncome(249744);
			nss.setDeductions( Utility.computeDeductions( nss ) );

		ans = ans && ns.equals( nss );

		Employee nb = DataScience.highestPaidEmployee( "nb", map ),
			nbb = new Employee();
			nbb.setSerialNumber(5018);
			nbb.setName("Maruanto Mazindara");
			nbb.setSex("N");
			nbb.setDob("24-02-42934");
			nbb.setMaritalStatus("Divorced");
			nbb.setProvince("NB");
			nbb.setIncome(249744);
			nbb.setDeductions( Utility.computeDeductions( nbb ) );

		ans = ans && nb.equals( nbb );

		Employee sk = DataScience.highestPaidEmployee( "sk", map ),
			skk = new Employee();
			skk.setSerialNumber(5862);
			skk.setName("Maruanto Mazindara");
			skk.setSex("N");
			skk.setDob("24-02-42934");
			skk.setMaritalStatus("Divorced");
			skk.setProvince("SK");
			skk.setIncome(249744);
			skk.setDeductions( Utility.computeDeductions( skk ) );

		ans = ans && sk.equals( skk );

		Employee on = DataScience.highestPaidEmployee( "on", map ),
			onn = new Employee();
			onn.setSerialNumber(5962);
			onn.setName("Maruanto Mazindara");
			onn.setSex("N");
			onn.setDob("24-02-42934");
			onn.setMaritalStatus("Divorced");
			onn.setProvince("ON");
			onn.setIncome(249744);
			onn.setDeductions( Utility.computeDeductions( onn ) );

		ans = ans && on.equals( onn );
		
		answer[0] = ans;
		return answer;	
	}

	public static boolean evaluateQuestion( boolean [] questions ) {
		
		boolean answer = questions[0];
		for( boolean question : questions ) {
			answer = answer && question;
		}
		return answer;
	}

	private static boolean checkCategory( TaxCategory cat, double percentage, double lBound, double uBound ) {
		
		if( cat != null ) {
			return( cat.getPercentage() == percentage 
				&& cat.getLowerBound() == lBound 
					&& cat.getUpperBound() == uBound );
		}
		return false;
	}

	public static boolean[] test() {
		
		boolean[] test = new boolean[20];
		
		test[0] = evaluateQuestion( Q1() );
		test[1] = evaluateQuestion( Q2() );
		test[2] = evaluateQuestion( Q3() );
		test[3] = evaluateQuestion( Q4() );
		test[4] = evaluateQuestion( Q5() );
		test[5] = evaluateQuestion( Q6() );
		test[6] = evaluateQuestion( Q7() );
		test[7] = evaluateQuestion( Q8() );
		test[8] = evaluateQuestion( Q9() );
		test[9] = evaluateQuestion( Q10() );
		test[10] = evaluateQuestion( Q11() );
		test[11] = evaluateQuestion( Q12() );
		test[12] = evaluateQuestion( Q13() );
		test[13] = evaluateQuestion( Q14() );
		test[14] = evaluateQuestion( Q15() );
		test[15] = evaluateQuestion( Q16() );
		test[16] = evaluateQuestion( Q17() );
		test[17] = evaluateQuestion( Q18() );
		test[18] = evaluateQuestion( Q19() );
		test[19] = evaluateQuestion( Q20() );
		return test;
	}
}