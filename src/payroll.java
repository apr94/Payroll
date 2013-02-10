

import java.awt.*;
import java.awt.print.PrinterException;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.TitledBorder;
import java.io.*;

public class payroll {

    JFrame frame;
    JPanel gridPanel = new JPanel();
    JPanel controlPanel;
    JTabbedPane tabs;
    String content;
    
    JTextArea sSummary;
    JScrollPane scrollPane;
    TitledBorder title;

    String name;
    String nameDir;
    String yearDir;
    String employeeDir = "Employees";
    String infoDir = "Information";
    String viewFile;

    String[] HoursList = {"00","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    String[] MinutesList = {"00","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12","13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24","25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36","37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48","49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
    String[] months = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC" };
    String[] days28 = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12","13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24","25", "26", "27", "28" };
   

    SpinnerListModel sHourModel = new SpinnerListModel(HoursList);
    SpinnerListModel sMinuteModel = new SpinnerListModel(MinutesList);

    SpinnerListModel eHourModel = new SpinnerListModel(HoursList);
    SpinnerListModel eMinuteModel = new SpinnerListModel(MinutesList);
    
    SpinnerListModel sBHourModel = new SpinnerListModel(HoursList);
    SpinnerListModel sBMinuteModel = new SpinnerListModel(MinutesList);
    
    SpinnerListModel eBHourModel = new SpinnerListModel(HoursList);
    SpinnerListModel eBMinuteModel = new SpinnerListModel(MinutesList);

    SpinnerListModel bHourModel = new SpinnerListModel(HoursList);
    SpinnerListModel bMinuteModel = new SpinnerListModel(MinutesList);

    JSpinner agHourspinner = new JSpinner(sHourModel);
    JSpinner agMinutespinner = new JSpinner(sMinuteModel);
    JSpinner aEHourSpinner = new JSpinner(eHourModel);
    JSpinner aEMinuteSpinner = new JSpinner(eMinuteModel);
    
    JSpinner aBgHourspinner = new JSpinner(sBHourModel);
    JSpinner aBgMinutespinner = new JSpinner(sBMinuteModel);
    JSpinner aBEHourSpinner = new JSpinner(eBHourModel);
    JSpinner aBEMinuteSpinner = new JSpinner(eBMinuteModel);
    
    JSpinner aBHourSpinner = new JSpinner(bHourModel);
    JSpinner aBMinuteSpinner = new JSpinner(bMinuteModel);


    
    String email;
    int age;
    int SCN;
    String nGender;
    String fileName;
    String error;


    int hours;
    String gHours;
    String nHours;
    int minutes;
    String nMinutes;
    String gMinutes;

    int start;
    int end;
    int bStartHour;
    int bStartMinute;
    int bEndHour;
    int bEndMinute;
    int totalBreakTime;
    String tBreakTime = "-";
    String bStartTime = "-";
    String bEndTime = "-";
    int rate;
    int time_in_minutes;
    int tHours;
    float pay;
    float wages;
    String sTHours;
    String sTMinutes;
    int tMinutes;
    int startHour;
    int startMinute;
    int endHour;
    int endMinute;
    int response;

    String startTime;
    String endTime;
    String tBH;
    String tBM;

    String date;
    String comment;
    String[] tokens;
    String[] HM;
    File file;
    File nDir;
    File vNDir;
    File aNDir;
    File eDir;
    File vEDir;
    File aEDir;
    File temp;
    PrintWriter pw;
    PrintWriter pwe;
    FileWriter fw;
    BufferedReader br;
    BufferedWriter bw;
    FileReader fr;

    String[] aEmployeesArray;
    String[] vEmployeesArray;
    String[] vYearsArray;
    String[] aYearsArray;


    JComboBox aEmployees;
    JTextField aYears;
    JComboBox vEmployees;
    JComboBox vYears;
    JComboBox mE;
    JComboBox yE;
    JComboBox nE;
    JComboBox aE;

    JComboBox days;
    JComboBox cbMonths;
    JComboBox nMonths;
    JComboBox cpMonths;
    JComboBox years;


    JRadioButton SAM = new JRadioButton("AM");
    JRadioButton SPM = new JRadioButton("PM");
    ButtonGroup sGroup = new ButtonGroup();

    JRadioButton EAM = new JRadioButton("AM");
    JRadioButton EPM = new JRadioButton("PM");
    ButtonGroup eGroup = new ButtonGroup();

    JRadioButton BSAM = new JRadioButton("AM");
    JRadioButton BSPM = new JRadioButton("PM");
    ButtonGroup sBGroup = new ButtonGroup();

    JRadioButton BEAM = new JRadioButton("AM");
    JRadioButton BEPM = new JRadioButton("PM");
    ButtonGroup eBGroup = new ButtonGroup();

    JRadioButton M = new JRadioButton("Male");
    JRadioButton F = new JRadioButton("Female");
    ButtonGroup gGroup = new ButtonGroup();

    JRadioButton TPB = new JRadioButton("Break: Time Period");
    JRadioButton SVB = new JRadioButton("Break: Set value");
    ButtonGroup bGroup = new ButtonGroup();

         JLabel nFnameLabel = new JLabel("Name:");
         JLabel nSnameLabel = new JLabel("Surname:");
         JLabel nEmailLabel = new JLabel("Email ID:");
         JLabel nAgeLabel = new JLabel("Age:");
         JLabel nSCNLabel = new JLabel("SC Number:");
         JLabel nMonthLabel  = new JLabel("Month:");
         JLabel nYearLabel = new JLabel("Year");
         JTextField nFname = new JTextField(50);
         JTextField nSname = new JTextField(50);
         JTextField nEmail = new JTextField(50);
         JTextField nAge = new JTextField(2);
         JTextField nSCN = new JTextField(50);
         JTextField nYear = new JTextField(50);
         JButton nAddMemberButton = new JButton("Add member");


         JLabel aFSnameLabel = new JLabel("Name:");
         JLabel aMonthLabel = new JLabel("Month:");
         JLabel aStartHourLabel = new JLabel("Start Hour:");
         JLabel aEndHourLabel = new JLabel("End Hour:");
         JLabel aStartMinuteLabel = new JLabel("Start Minute:");
         JLabel aEndMinuteLabel = new JLabel("End Minute:");
         JLabel aBStartHourLabel = new JLabel("Start Hour:");
         JLabel aBEndHourLabel = new JLabel("End Hour:");
         JLabel aBStartMinuteLabel = new JLabel("Start Minute:");
         JLabel aBEndMinuteLabel = new JLabel("End Minute:");
         JLabel aDateLabel = new JLabel("Date:");
         JLabel aWageLabel = new JLabel("Hourly Wage:");
         JLabel aYearLabel = new JLabel("Year");
         JLabel aBHourLabel = new JLabel("Hour(s)");
         JLabel aBMinuteLabel = new JLabel("Minutes(s)");
         JTextField aSearchFSName = new JTextField(50);
         JTextField aWage = new JTextField(50);
         JButton aAddHoursButton = new JButton("Add Hours");
         JButton aAddBreakButton = new JButton("Add Break");
         JButton aConfirmBreakButton = new JButton("Confirm");

         JFrame breakFrame;
         JPanel choicePanel = new JPanel();
         JPanel pBreakPanel = new JPanel();
         JPanel sBreakPanel = new JPanel();
         JPanel buttonPanel = new JPanel();

         JLabel abAboutLabel = new JLabel("Payroll Program");

         JMenuBar menuBar = new JMenuBar();
         JMenu menu  = new JMenu("File");
         JMenuItem nullItem = new JMenuItem("");
         JMenuItem saveMenuItem = new JMenuItem("Save                                                    ");
         JMenuItem printMenuItem = new JMenuItem("Print                                                  ");


          JButton prev = new JButton("<<");
          JButton next = new JButton(">>");
          JLabel cpNameLabel = new JLabel("Name");
          JLabel cpMonthLabel = new JLabel("Month");
          JLabel cpYearLabel = new JLabel("Year");
          JTextField cpYear = new JTextField(50);


         JPanel Add = new JPanel(new GridLayout(3,8));
         JPanel New = new JPanel(new GridLayout(2,11));
         JPanel About = new JPanel();


    public static void main(String[] args) {

        payroll payroll = new payroll();
        payroll.buildGUI();

    }

public void set_radioButtons()
{
    SAM.setMnemonic(KeyEvent.VK_A);
    SAM.setActionCommand("AM");
    SAM.setSelected(true);

    SPM.setMnemonic(KeyEvent.VK_P);
    SPM.setActionCommand("PM");

    sGroup.add(SAM);
    sGroup.add(SPM);

    EAM.setMnemonic(KeyEvent.VK_A);
    EAM.setActionCommand("AM");
    EAM.setSelected(true);

    EPM.setMnemonic(KeyEvent.VK_P);
    EPM.setActionCommand("PM");

    eGroup.add(EAM);
    eGroup.add(EPM);

     BSAM.setMnemonic(KeyEvent.VK_A);
    BSAM.setActionCommand("AM");
    BSAM.setSelected(true);

    BSPM.setMnemonic(KeyEvent.VK_P);
    BSPM.setActionCommand("PM");

    sBGroup.add(BSAM);
    sBGroup.add(BSPM);

    BEAM.setMnemonic(KeyEvent.VK_A);
    BEAM.setActionCommand("AM");
    BEAM.setSelected(true);

    BEPM.setMnemonic(KeyEvent.VK_P);
    BEPM.setActionCommand("PM");

    eBGroup.add(BEAM);
    eBGroup.add(BEPM);

    M.setMnemonic(KeyEvent.VK_M);
    M.setActionCommand("Male");
    M.setSelected(true);

    F.setMnemonic(KeyEvent.VK_F);
    F.setActionCommand("Female");

    gGroup.add(M);
    gGroup.add(F);

    TPB.setMnemonic(KeyEvent.VK_T);
    TPB.setActionCommand("TPB");
    TPB.setSelected(true);

    SVB.setMnemonic(KeyEvent.VK_S);
    SVB.setActionCommand("SVB");
    deactivateSVB();

    gGroup.add(TPB);
    gGroup.add(SVB);
}


  public void vEmployeesMethod()
         {
         vEmployees = new JComboBox();
         vYears = new JComboBox();
         vEDir = new File("Employees");
         vEmployeesArray = vEDir.list();

         if(vEmployeesArray != null)
         {
           
        for(int i = 0; i < vEmployeesArray.length; i++)
        {
            if(vEmployeesArray[i].length() > 8)
            {
                if(vEmployeesArray[i].equals("AAAAAAAAAA"))
                {
                      vEmployees.insertItemAt("-------------", i);
                }
                else{
              String tmp = vEmployeesArray[i].substring(0, 5)+"..";
             vEmployees.insertItemAt(tmp, i);
            }
            }
                else if( vEmployeesArray[i].toUpperCase().equals(vEmployeesArray[i]))
                {
                  String tmp = vEmployeesArray[i].substring(0, 4)+"...";
                   vEmployees.insertItemAt(tmp, i);
                }

            else{
        vEmployees.insertItemAt(vEmployeesArray[i], i);
            }
        }
         }

         else
         {
         vEmployees.insertItemAt("-------------", 0);
         }

         }

         public void aEmployeesMethod()
         {
         aEmployees = new JComboBox();
         aYears = new JTextField();
         aEDir = new File("Employees");
         aEmployeesArray = vEDir.list();

         if(aEmployeesArray != null)
         {
           
        for(int i = 0; i < aEmployeesArray.length; i++)
        {
            if(aEmployeesArray[i].length() > 8)
            {
                if(aEmployeesArray[i].equals("AAAAAAAAAA"))
                {
                      aEmployees.insertItemAt("-------------", i);
                }
                else{
              String tmp = aEmployeesArray[i].substring(0, 5)+"..";
             aEmployees.insertItemAt(tmp, i);
            }
            }
                else if( aEmployeesArray[i].toUpperCase().equals(aEmployeesArray[i]))
                {
                  String tmp = aEmployeesArray[i].substring(0, 4)+"...";
                   aEmployees.insertItemAt(tmp, i);
                }

            else{
        aEmployees.insertItemAt(aEmployeesArray[i], i);
            }
        }
         }

         else
         {
         aEmployees.insertItemAt("-------------", 0);
         }
         }

      
        public void set_date(){   
            cbMonths = new JComboBox(months);
            cbMonths.setSelectedIndex(1);
            cpMonths = new JComboBox(months);
            cpMonths.setSelectedIndex(1);
            nMonths = new JComboBox(months);
            nMonths.setSelectedIndex(1);
            days = new JComboBox(days28);
            days.setEditable(true);
          cbMonths.addActionListener(new dateListener());}

    public void buildGUI()
    {
        vEmployeesMethod();
        aEmployeesMethod();
        set_radioButtons();
        set_date();
        setUpBreak();

        menu.add(nullItem);
        menu.add(saveMenuItem);
        menu.addSeparator();
        menu.add(printMenuItem);
        menu.addSeparator();
        menu.add(nullItem);
        menuBar.add(menu);

         tabs = new JTabbedPane();
         tabs.addChangeListener(new paneChangeListener());
         frame = new JFrame("Payroll program");
         




         nAddMemberButton.addActionListener(new addMemberListener());
         aAddHoursButton.addActionListener(new addHourListener());
         aAddBreakButton.addActionListener(new addBreakListener());
         aConfirmBreakButton.addActionListener(new ConfirmBreakListener());
         TPB.addActionListener(new breakChoice());
         SVB.addActionListener(new breakChoice());
         vEmployees.addActionListener(new vEmployeesListener());
         aEmployees.addActionListener(new aEmployeesListener());
         vYears.addActionListener(new vYearsListener());
         cpMonths.addActionListener(new cpMonthsListener());
         prev.addActionListener(new prevListener());
         next.addActionListener(new nextListener());
         printMenuItem.addActionListener(new printItemListener());
         saveMenuItem.addActionListener(new saveItemListener());



         sSummary = new JTextArea();
         sSummary.setTabSize(8);
         scrollPane = new JScrollPane(sSummary);
         scrollPane.setPreferredSize(new Dimension(1000, 1000));
         



         New.add(nFnameLabel);
         New.add(nFname);
         New.add(nSnameLabel);
         New.add(nSname);
         New.add(nSCNLabel);
         New.add(nSCN);
         New.add(nEmailLabel);
         New.add(nEmail);
         New.add(new JPanel());
         New.add(nAgeLabel);
         New.add(nAge);
         New.add(M);
         New.add(F);
         New.add(nMonthLabel);
         New.add(nMonths);
         New.add(nYearLabel);
         New.add(nYear);
         New.add(nAddMemberButton);

         Add.add(aFSnameLabel);
         Add.add(aEmployees);
         Add.add(aYearLabel);
         Add.add(aYears);
         Add.add(aMonthLabel);
         Add.add(cbMonths);
         Add.add(aDateLabel);
         Add.add(days);

         Add.add(aStartHourLabel);
         Add.add(agHourspinner);
         Add.add(aStartMinuteLabel);
         Add.add(agMinutespinner);
         Add.add(SAM);
         Add.add(SPM);
         Add.add(aWageLabel);
         Add.add(aWage);

         Add.add(aEndHourLabel);
         Add.add(aEHourSpinner);
         Add.add(aEndMinuteLabel);
         Add.add(aEMinuteSpinner);
         Add.add(EAM);
         Add.add(EPM);
         Add.add(aAddBreakButton);
         Add.add(aAddHoursButton);

         About.add(abAboutLabel);

         tabs.add("Add Members", New);
         tabs.add("Add Hours", Add);
         tabs.add("About", About);
         tabs.setPreferredSize(new Dimension(1000, 500));

        controlPanel = new JPanel(new GridLayout(1,12));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10,5,10,5));
    
        controlPanel.add(prev);
        controlPanel.add(new JPanel());
        controlPanel.add(cpNameLabel);
        controlPanel.add(vEmployees);
        controlPanel.add(new JPanel());
        controlPanel.add(cpYearLabel);
        controlPanel.add(vYears);
        controlPanel.add(new JPanel());
        controlPanel.add(cpMonthLabel);
        controlPanel.add(cpMonths);
        controlPanel.add(new JPanel());
        controlPanel.add(next);

         gridPanel = new JPanel(new GridBagLayout());
         gridPanel.setPreferredSize(new Dimension(1000, 150));
         GridBagConstraints c = new GridBagConstraints();

         gridPanel.add(tabs);
         c.ipady =0;
         c.weightx = 0.0;
         c.gridx = 0;
         c.gridy = 1;
         gridPanel.add(controlPanel,c);

         frame.getContentPane().add(gridPanel, BorderLayout.NORTH);
         frame.getContentPane().add(scrollPane);
         frame.setVisible(true);
         frame.setSize(1055, 500);
         frame.setJMenuBar(menuBar);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // Listeners


    class saveItemListener implements ActionListener
    {
        @Override

           public void actionPerformed(ActionEvent event)
    {
            saveMethod();
    }
    }


      class printItemListener implements ActionListener
    {
        @Override

           public void actionPerformed(ActionEvent event)
    {
     try{
    sSummary.print(null, null, true, null, null, true);
    }
   catch (PrinterException ex) {}


        }
    }

    class vEmployeesListener implements ActionListener
    {
        @Override
           public void actionPerformed(ActionEvent event)
    {
             vYears.removeAllItems();
             nE = (JComboBox)event.getSource();
             vNDir = new File("Employees/"+vEmployeesArray[nE.getSelectedIndex()]+"/DATA");
             vYearsArray = vNDir.list();

         if(vYearsArray != null)
         {
             for(int i = 0; i < vYearsArray.length; i++)
             {
         vYears.insertItemAt(vYearsArray[i], i);
             }
         }
    }
    }
    
      class aEmployeesListener implements ActionListener
    {
     @Override
           public void actionPerformed(ActionEvent event)
    {
         /*       aYears.removeAllItems();
             aE = (JComboBox)event.getSource();
             aNDir = new File("employees/"+vEmployeesArray[aE.getSelectedIndex()]);
             aYearsArray = aNDir.list();

         if(aYearsArray != null)
         {
             for(int i = 0; i < aYearsArray.length; i++)
             {
         aYears.insertItemAt(aYearsArray[i], i);
             }
         }*/
    }
    }

    class vYearsListener implements ActionListener
    {
        @Override
           public void actionPerformed(ActionEvent event)
    {
           yE = (JComboBox)event.getSource();
    }
    }

      class cpMonthsListener implements ActionListener
      {
          @Override
         public void actionPerformed(ActionEvent event)
         {
             mE = (JComboBox)event.getSource();
              sSummary.setText("");
              viewFile = "Employees/"+vEmployeesArray[nE.getSelectedIndex()]+"/DATA/"+yE.getSelectedItem().toString()+"/"+mE.getSelectedItem().toString()+".txt";
              sSummary.setText("");
try{

br = new BufferedReader(fr = new FileReader(viewFile));
while((content = br.readLine()) != null)
{
sSummary.append(content+'\n');
}
fr.close();
br.close();
}
catch(IOException IOE)
{
   error = "No file for Month "+mE.getSelectedItem().toString()+" of year "+yE.getSelectedItem().toString()+" for employee "+vEmployeesArray[nE.getSelectedIndex()]+". ";
   sSummary.setText(error);
}  
         }
      }


    class prevListener implements ActionListener
   {

   @Override

   public void actionPerformed(ActionEvent event)
    {
       prevMethod();
    }

   }

 class nextListener implements ActionListener
   {

   @Override

   public void actionPerformed(ActionEvent event)
    {
       nextMethod();
    }

   }


    class addMemberListener implements ActionListener
   {

   @Override

   public void actionPerformed(ActionEvent event)
    {
       addMember();
    }

   }

      class addBreakListener implements ActionListener
   {

   @Override

   public void actionPerformed(ActionEvent event)
    {

   popup();
    }

   }

        class ConfirmBreakListener implements ActionListener
   {

   @Override

   public void actionPerformed(ActionEvent event)
    {
       dispose();
       showMessage();
    }

   }

    class addHourListener implements ActionListener
   {

   @Override

   public void actionPerformed(ActionEvent event)
    {
    addHours();
    update_hours();
    update_files();
    transfer_data();
    }

   }

     class breakChoice implements ActionListener
   {

   @Override

   public void actionPerformed(ActionEvent event)
    {
   if(event.getActionCommand().equals("TPB"))
   {
   deactivateSVB();
   activateTPB();
   }

   else if(event.getActionCommand().equals("SVB"))
   {
   deactivateTPB();
   activateSVB();
   }
    }

   }

     class dateListener implements ActionListener
   {

   @Override

   public void actionPerformed(ActionEvent e)
    {

    JComboBox cb = (JComboBox)e.getSource();

            if(cb.getSelectedItem().toString().equals("FEB"))
  {
   if(Integer.parseInt(aYears.getText().toString())%100 == 0)
   {
       if(Integer.parseInt(aYears.getText().toString())%400 == 0)
   {    days.removeItem("29");
        days.removeItem("30");
        days.removeItem("31");
        days.addItem("29");
    }
    else
    {
        days.removeItem("29");
        days.removeItem("30");
        days.removeItem("31");
    }
   }
   else if(Integer.parseInt(aYears.getText().toString())%4 == 0)
   {
        days.removeItem("29");
        days.removeItem("30");
        days.removeItem("31");
        days.addItem("29");
   }
   else
   {
      days.removeItem("29");
        days.removeItem("30");
        days.removeItem("31");
   }
  }



    else if(cb.getSelectedItem().toString().equals("JAN") || cb.getSelectedItem().toString().equals("APR") || cb.getSelectedItem().toString().equals("JUN") || cb.getSelectedItem().toString().equals("SEP")|| cb.getSelectedItem().toString().equals("NOV"))
     {
      days.removeItem("29");
      days.removeItem("30");
      days.removeItem("31");
      days.addItem("29");
      days.addItem("30");
      days.setEditable(true);}
     else if(cb.getSelectedItem().toString().equals("MAR") || cb.getSelectedItem().toString().equals("MAY")|| cb.getSelectedItem().toString().equals("JUL")|| cb.getSelectedItem().toString().equals("AUG") || cb.getSelectedItem().toString().equals("OCT")|| cb.getSelectedItem().toString().equals("DEC"))
     {
      days.removeItem("29");
      days.removeItem("30");
      days.removeItem("31");
      days.addItem("29");
      days.addItem("30");
      days.addItem("31");
      days.setEditable(true); }

      }
     }

     class paneChangeListener implements ChangeListener
     {
     public void stateChanged(ChangeEvent evt)
     {
         
    
     }
     }
     
// methods

     public void saveMethod()
{
      viewFile = "Employees/"+vEmployeesArray[nE.getSelectedIndex()]+"/"+yE.getSelectedItem().toString()+"/"+months[mE.getSelectedIndex()]+".txt";
 
    try
      {
      fw = new FileWriter(viewFile);
      sSummary.write(fw);
      }
    catch (IOException exception)
    {
    }
      finally
      {
      if (fw != null)
      {
        try
        {
          fw.close();
        }
        catch (IOException exception)
        {
        }
      }
    }

}

 public void prevMethod()
 {
     viewFile = "Employees/"+vEmployeesArray[nE.getSelectedIndex()]+"/"+yE.getSelectedItem().toString()+"/"+months[mE.getSelectedIndex()-1]+".txt";
     mE.setSelectedIndex(mE.getSelectedIndex()-1);
     sSummary.setText("");
 try{

br = new BufferedReader(fr = new FileReader(viewFile));
while((content = br.readLine()) != null)
{
sSummary.append(content+'\n');
}
fr.close();
br.close();
}
catch(IOException IOE)
{
   error = "No file for Month "+mE.getSelectedItem().toString()+" of year "+yE.getSelectedItem().toString()+" for employee "+vEmployeesArray[nE.getSelectedIndex()]+". ";
   sSummary.setText(error);
}

 }

 public void nextMethod()
 {
 viewFile = "Employees/"+vEmployeesArray[nE.getSelectedIndex()]+"/"+yE.getSelectedItem().toString()+"/"+months[mE.getSelectedIndex()+1]+".txt";
     mE.setSelectedIndex(mE.getSelectedIndex()+1);
     sSummary.setText("");
 try{

br = new BufferedReader(fr = new FileReader(viewFile));
while((content = br.readLine()) != null)
{
sSummary.append(content+'\n');
}
fr.close();
br.close();
}
catch(IOException IOE)
{
   error = "No file for Month "+mE.getSelectedItem().toString()+" of year "+yE.getSelectedItem().toString()+" for employee "+vEmployeesArray[nE.getSelectedIndex()]+". ";
   sSummary.setText(error);
}
 }


public void addMember()
{
name = nFname.getText()+nSname.getText()+ ".txt";
nameDir = nFname.getText()+nSname.getText();
nGender = gGroup.getSelection().getActionCommand();
email = nEmail.getText();
SCN = Integer.parseInt(nSCN.getText());
age = Integer.parseInt(nAge.getText());
pay = 0;


try{
    if(new File(employeeDir).exists())
    {
    }
    else
    {
        eDir = new File(employeeDir);
        eDir.mkdir();
    }


nDir = new File(employeeDir+"/"+nameDir);
nDir.mkdir();
nDir = new File(employeeDir+"/"+nameDir+"/"+infoDir);
nDir.mkdir();
nDir = new File(employeeDir+"/"+nameDir+"/"+"DATA");
nDir.mkdir();

file = new File(employeeDir+"/"+nameDir+"/"+infoDir+"/"+name);
file.createNewFile();
pw = new PrintWriter(file);
pw.print("\tName: ");
pw.println(nFname.getText()+""+nSname.getText());
pw.print("\tAge: ");
pw.println(age);
pw.print("\tSC Number: ");
pw.println(SCN);
pw.print("\tGender: ");
pw.println(nGender);
pw.print("\tEmail: ");
pw.println(email);
//pw.println("\tDate\t\tStart Time\tEnd Time\tGross Hours\tBreak Start\tBreak End\tTotal Break\tNet Hours\tHourly Wages\tPay");

pw.flush();
pw.close();

nFname.setText("");
nSname.setText("");
nEmail.setText("");
nAge.setText("");
nSCN.setText("");
nYear.setText("");
JOptionPane.showMessageDialog(null, "Employee has been added!", "Notification", JOptionPane.INFORMATION_MESSAGE);
}
catch(IOException IOE){IOE.printStackTrace();}
}

public void addHours()
{

startTime = agHourspinner.getValue().toString()+":"+agMinutespinner.getValue().toString()+""+sGroup.getSelection().getActionCommand();
endTime = aEHourSpinner.getValue().toString()+":"+aEMinuteSpinner.getValue().toString()+""+eGroup.getSelection().getActionCommand();

startHour = Integer.parseInt(agHourspinner.getValue().toString());
if(sGroup.getSelection().getActionCommand().equals("PM") && startHour != 12){startHour = startHour+12;}
if(sGroup.getSelection().getActionCommand().equals("AM") && startHour == 12){startHour = startHour+12;}
startMinute = Integer.parseInt(agMinutespinner.getValue().toString());
start = startHour*60 + startMinute;


endHour = Integer.parseInt(aEHourSpinner.getValue().toString());
if(eGroup.getSelection().getActionCommand().equals("PM") && endHour != 12){endHour = endHour+12;}
if(eGroup.getSelection().getActionCommand().equals("AM") && endHour == 12){endHour = endHour+12;}
endMinute = Integer.parseInt(aEMinuteSpinner.getValue().toString());
end = endHour*60 + endMinute;

time_in_minutes = end-start;
if(time_in_minutes < 60){hours = 0;}
else{
hours = time_in_minutes/60;}
gHours = Integer.toString(hours);
minutes = time_in_minutes % 60;
nHours = Integer.toString((hours*60+minutes-(totalBreakTime))/60);
if(gHours.length() < 2){gHours = "0"+gHours;}
if(nHours.length() < 2){nHours = "0"+nHours;}
gMinutes= Integer.toString(minutes);
nMinutes = Integer.toString((hours*60+minutes-(totalBreakTime))%60);
if(gMinutes.length() < 2){gMinutes = "0"+gMinutes;}
if(nMinutes.length() < 2){nMinutes = "0"+nMinutes;}

date = days.getSelectedItem()+" "+cbMonths.getSelectedItem()+" "+aYears.getText().toString();

wages =  Integer.parseInt(aWage.getText());
pay = ((wages *Integer.parseInt(nHours)) + (wages * Integer.parseInt(nMinutes)/60));

try{

fileName = employeeDir+"/"+aEmployeesArray[aEmployees.getSelectedIndex()]+"/DATA/"+aYears.getText().toString()+"/"+cbMonths.getSelectedItem().toString()+".txt";
if(!new File(fileName).exists())
    {
        
        nDir = new File( employeeDir+"/"+aEmployeesArray[aEmployees.getSelectedIndex()]+"/DATA/"+aYears.getText().toString());
        nDir.mkdir();
        nDir = new File(fileName);
        nDir.createNewFile();
                fr = new FileReader(employeeDir+"/"+aEmployeesArray[aEmployees.getSelectedIndex()]+"/"+infoDir+"/"+aEmployeesArray[aEmployees.getSelectedIndex()]+".txt");
        br = new BufferedReader(fr);
        
       
        pw = new PrintWriter(fileName);
         
         while ((content = br.readLine()) != null)
         {
             pw.println(content);
         }
       
         
         pw.println("\tMonth: " + cbMonths.getSelectedItem().toString());
         pw.println("\tYear: " + aYears.getText().toString());
         pw.println("\tHours-> 0:0");
         pw.println("\tTotal Pay-> $0.0");
         pw.println("");
         pw.println("");
         pw.println("");
         pw.println("\tDate\t\tStart Time\tEnd Time\tGross Hours\tBreak Start\tBreak End\tTotal Break\tNet Hours\tHourly Wages\tPay");
         pw.flush();
         pw.close();

         
        
    }

fw = new FileWriter(fileName, true);
fw.append("\t"+date+"\t"+startTime+"\t\t"+endTime+"\t\t"+gHours+":"+gMinutes+"\t\t"+bStartTime+"\t\t"+bEndTime+"\t\t"+tBreakTime+"\t\t"+nHours+":"+nMinutes+"\t\t"+wages+"\t\t"+"$"+pay);


pw = new PrintWriter(new FileWriter((fileName), true));
pw.println("");
fw.flush();
fw.close();
pw.flush();
pw.close();
JOptionPane.showMessageDialog(null, "Hours have been added!", "Notification", JOptionPane.INFORMATION_MESSAGE);
}
catch(IOException E){JOptionPane.showMessageDialog(null, "Hours have not been added, please try again!" , "Error", JOptionPane.ERROR_MESSAGE);}
}


public void update_hours()
{
 try {
 fr = new FileReader(fileName);
 br = new BufferedReader(fr);

 while ((content = br.readLine()) != null){
 if(content.contains("Hours->"))
 {

 tokens = content.split("->");
 HM = tokens[1].split(":");
 tHours = Integer.parseInt(HM[0].substring(1));
 tMinutes = Integer.parseInt(HM[1]);
 tHours = tHours + Integer.parseInt(nHours);
 tMinutes = tMinutes + Integer.parseInt(nMinutes);
 if(tMinutes > 59){tHours = tHours+tMinutes/60; tMinutes = tMinutes%60;}
 sTHours = Integer.toString(tHours);
 if(sTHours.length() < 2){sTHours = "0"+sTHours;}
 sTMinutes = Integer.toString(tMinutes);
 if(sTMinutes.length() < 2){sTMinutes = "0"+sTMinutes;}

 }
 
if(content.contains("Total Pay->"))
{
     tokens = content.split("->");
     pay += Float.parseFloat(tokens[1].substring(2));
}
}
    } catch (FileNotFoundException e) {}
 catch (IOException e) {}
}

public void update_files()
{
         try {
            br = new BufferedReader(fr = new FileReader(fileName));
            pw = new PrintWriter(fw = new FileWriter(("Temp.txt"), true));

            while ((content = br.readLine()) != null)
            {
            if(content.contains("\tHours->"))
            {
              pw.println("\tHours-> "+sTHours+":"+sTMinutes);
            }
            else if(content.contains("\tTotal Pay->"))   
            {
                pw.println("\tTotal Pay-> $"+pay);
            }
                    
                    
            else{pw.println(content);}
            }
            fw.flush();
            fw.close();
            pw.flush();
            pw.close();
            fr.close();
            br.close();


        } catch (FileNotFoundException ffx) {
            ffx.printStackTrace();
        } catch (IOException iox) {
            iox.printStackTrace();
        }

}

public void transfer_data()
{
 try {
 br = new BufferedReader(fr = new FileReader(temp = new File ("Temp.txt")));
 pw = new PrintWriter(fw = new FileWriter(((fileName)), true));
 pwe = new PrintWriter(fileName);

     while ((content = br.readLine()) != null)
            {
            pwe.write("");
            pw.println(content);
            }
            pwe.flush();
            pwe.close();
            fw.flush();
            fw.close();
            pw.flush();
            pw.close();
            fr.close();
            br.close();

            temp.delete();


        }
          catch (FileNotFoundException ffx) {}
          catch (IOException IOE) {}
}

public void setUpBreak()
{
    pBreakPanel.setLayout(new GridLayout(6, 5));
    title = new TitledBorder("Time Period");
    pBreakPanel.setBorder(title);


   sBreakPanel.setLayout(new GridLayout(5, 4));
   title = new TitledBorder("Set Break Value");
   sBreakPanel.setBorder(title);


   choicePanel.setLayout(new GridLayout(1, 4));
   choicePanel.setBorder(BorderFactory.createEmptyBorder(10,5,10,0));

   buttonPanel.setLayout(new GridLayout(1, 3));
   buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,5,10,5));


    
    choicePanel.add(TPB);
    choicePanel.add(new JPanel());
    choicePanel.add(new JPanel());
    choicePanel.add(SVB);
    


     pBreakPanel.add(new JPanel());
      pBreakPanel.add(new JPanel());
       pBreakPanel.add(new JPanel());
        pBreakPanel.add(new JPanel());
         pBreakPanel.add(new JPanel());
         pBreakPanel.add(new JPanel());
        pBreakPanel.add(aBStartHourLabel);
       pBreakPanel.add(aBgHourspinner);
      pBreakPanel.add(BSAM);
     pBreakPanel.add(BSPM);

    pBreakPanel.add(new JPanel());
    pBreakPanel.add(aBStartMinuteLabel);
    pBreakPanel.add(aBgMinutespinner);
    pBreakPanel.add(new JPanel());
    pBreakPanel.add(new JPanel());

    pBreakPanel.add(new JPanel());
    pBreakPanel.add(aBEndHourLabel);
    pBreakPanel.add(aBEHourSpinner);
    pBreakPanel.add(BEAM);
    pBreakPanel.add(BEPM);

    pBreakPanel.add(new JPanel());
    pBreakPanel.add(aBEndMinuteLabel);
    pBreakPanel.add(aBEMinuteSpinner);
    pBreakPanel.add(new JPanel());
    pBreakPanel.add(new JPanel());

     pBreakPanel.add(new JPanel());
      pBreakPanel.add(new JPanel());
       pBreakPanel.add(new JPanel());
        pBreakPanel.add(new JPanel());
         pBreakPanel.add(new JPanel());

    sBreakPanel.add(new JPanel());
    sBreakPanel.add(new JPanel());
    sBreakPanel.add(new JPanel());
    sBreakPanel.add(new JPanel());

    sBreakPanel.add(new JPanel());
    sBreakPanel.add(aBHourSpinner);
    sBreakPanel.add(aBHourLabel);
    sBreakPanel.add(new JPanel());

    sBreakPanel.add(new JPanel());
    sBreakPanel.add(aBMinuteSpinner);
    sBreakPanel.add(aBMinuteLabel);
    sBreakPanel.add(new JPanel());

    sBreakPanel.add(new JPanel());
    sBreakPanel.add(new JPanel());
    sBreakPanel.add(new JPanel());
    sBreakPanel.add(new JPanel());

    sBreakPanel.add(new JPanel());
    sBreakPanel.add(new JPanel());
    sBreakPanel.add(new JPanel());
    sBreakPanel.add(new JPanel());

    buttonPanel.add(new JPanel());
    buttonPanel.add(aConfirmBreakButton);
    buttonPanel.add(new JPanel());

  breakFrame = new JFrame("Set Break");
  breakFrame.setSize(650,300);
  breakFrame.setLocationRelativeTo(null);
  breakFrame.getContentPane().add(pBreakPanel, BorderLayout.WEST);
  breakFrame.getContentPane().add(sBreakPanel, BorderLayout.EAST);
  breakFrame.getContentPane().add(choicePanel, BorderLayout.NORTH);
  breakFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

}

public void popup()
{
  breakFrame.setVisible(true);
  reset();
}

public void dispose()
{
breakFrame.dispose();
}

public void deactivateSVB()
{
aBHourSpinner.setEnabled(false);
aBMinuteSpinner.setEnabled(false);
aBHourLabel.setEnabled(false);
aBMinuteLabel.setEnabled(false);
}

public void deactivateTPB()
{
aBgHourspinner.setEnabled(false);
aBgMinutespinner.setEnabled(false);
aBStartHourLabel.setEnabled(false);
aBStartMinuteLabel.setEnabled(false);

aBEHourSpinner.setEnabled(false);
aBEMinuteSpinner.setEnabled(false);
aBEndHourLabel.setEnabled(false);
aBEndMinuteLabel.setEnabled(false);

BSAM.setEnabled(false);
BSPM.setEnabled(false);
BEAM.setEnabled(false);
BEPM.setEnabled(false);
}

public void activateSVB()
{
aBHourSpinner.setEnabled(true);
aBMinuteSpinner.setEnabled(true);
aBHourLabel.setEnabled(true);
aBMinuteLabel.setEnabled(true);


}

public void activateTPB()
{
aBgHourspinner.setEnabled(true);
aBgMinutespinner.setEnabled(true);
aBStartHourLabel.setEnabled(true);
aBStartMinuteLabel.setEnabled(true);

aBEHourSpinner.setEnabled(true);
aBEMinuteSpinner.setEnabled(true);
aBEndHourLabel.setEnabled(true);
aBEndMinuteLabel.setEnabled(true);

BSAM.setEnabled(true);
BSPM.setEnabled(true);
BEAM.setEnabled(true);
BEPM.setEnabled(true);

}

public void reset()
{
    bStartMinute = 0;
    bStartHour = 0;
    bEndMinute = 0;
    bEndHour = 0;
    bStartTime = "-";
    bEndTime = "-";
    totalBreakTime = 0;
    tBreakTime = "-";
    tBH = "-";
    tBM = "-";
    
}

public void showMessage()
{
    if(gGroup.getSelection().getActionCommand().equals("SVB"))

    {
    response = JOptionPane.showConfirmDialog(null, "Do you want to add "+aBHourSpinner.getValue().toString()+" hour(s) and " + aBMinuteSpinner.getValue().toString()+ " minute(s) as Break?", "Add Break hours?",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

    if (response == JOptionPane.YES_OPTION)
    {
    tBreakTime = aBHourSpinner.getValue().toString()+ ":" + aBMinuteSpinner.getValue().toString();
    tBH = aBHourSpinner.getValue().toString();
    tBM = aBMinuteSpinner.getValue().toString();
    totalBreakTime = Integer.parseInt(aBHourSpinner.getValue().toString())*60 + Integer.parseInt(aBMinuteSpinner.getValue().toString()) ;
   
    }
    }

    else
    {
     response = JOptionPane.showConfirmDialog(null, "Confirm Break Duration From "+aBgHourspinner.getValue().toString()+ ":" + aBgMinutespinner.getValue().toString()+ " "+ sBGroup.getSelection().getActionCommand()+" to " + aBEHourSpinner.getValue().toString()+ ":" + aBEMinuteSpinner.getValue().toString()+ " "+ eBGroup.getSelection().getActionCommand() + "?", "Confirm Break Duration", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     if (response == JOptionPane.YES_OPTION)
    {
        bStartTime = aBgHourspinner.getValue().toString()+ ":" + aBgMinutespinner.getValue().toString() + sBGroup.getSelection().getActionCommand();
        bEndTime = aBEHourSpinner.getValue().toString()+ ":" + aBEMinuteSpinner.getValue().toString() + eBGroup.getSelection().getActionCommand();

     bStartHour = Integer.parseInt(aBgHourspinner.getValue().toString());

     if(sBGroup.getSelection().getActionCommand().equals("PM") && bStartHour!=12)
     {
        bStartHour +=12;
     }
     
     if(sBGroup.getSelection().getActionCommand().equals("AM") && bStartHour==12)
     {
        bStartHour +=12;
     }
     
     bStartMinute = Integer.parseInt(aBgMinutespinner.getValue().toString());


      bEndHour = Integer.parseInt(aBEHourSpinner.getValue().toString());
     
     if(eBGroup.getSelection().getActionCommand().equals("PM") && bEndHour!=12 )
     {
        bEndHour +=12;
     }
     
     if(sBGroup.getSelection().getActionCommand().equals("AM") && bEndHour==12)
     {
        bEndHour +=12;
     }
     
     bEndMinute = Integer.parseInt(aBEMinuteSpinner.getValue().toString());
     
     totalBreakTime = (bEndHour-bStartHour)*60+(bEndMinute-bStartMinute);
     tBH = Integer.toString(totalBreakTime/60);
     tBM = Integer.toString(totalBreakTime%60);

     if(tBH.length() < 2)
     {
     tBH = "0"+tBH;
     }

      if(tBM.length() < 2)
     {
     tBM = "0"+tBM;
     }
     tBreakTime = tBH+":"+tBM;
    }

    }

    }

}

