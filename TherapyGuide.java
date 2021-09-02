//
// Name:    TherapyGuide.java - Main TherapyGuide Program
// Type:    Java source file
// Program: TherapyGuide - Physical Therapy Administer
// Author:  Aryan Samal
// Version: 1.0
//
// Copyright 2020, This software is confidential and proprietary to the author. Copy, download,
// and reproduction of the software in any form is prohibited unless for academic purposes.
//

import javax.imageio.ImageIO;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;

//
// TherapyGuide Class:
// Main program that creates the terminal window and displays all therapy postures
public class TherapyGuide extends JFrame implements ActionListener {

    // defines
    private static int MAX_BUTTONS          =   20;
    private static int ICON_LENGTH          =   120;
    private static int MAIN_FRAME_WIDTH     =   1000;
    private static int MAIN_FRAME_HEIGHT    =   650;
    private static int LEFT_BUTTON_WIDTH    =   120;
    private static int LEFT_BUTTON_HEIGHT   =   80;
    private static int LOWER_BUTTON_WIDTH   =   120;
    private static int LOWER_BUTTON_SCROLL_PANE_HEIGHT = 150;

    // GUI variables
    private JFrame mMainFrame;
    private JPanel mLowerButtonPanel;
    private JButton mFeetExercises[] = new JButton[MAX_BUTTONS];
    private JButton mKneeExercises[] = new JButton[MAX_BUTTONS];
    private JButton mHipExercises[] = new JButton[MAX_BUTTONS];
    private JButton mTrunkExercises[] = new JButton[MAX_BUTTONS];
    private JButton mLegExercises[] = new JButton[MAX_BUTTONS];
    private JButton mHandExercises[] = new JButton[MAX_BUTTONS];
    private JButton mHamstringExercises[] = new JButton[MAX_BUTTONS];
    private JScrollPane mLowerButtonScrollPane;
    private JPanel therapyPicturePanel;
    private JPanel mLeftButtonPanel;
    // data path
    private static String sDataPath = "data\\";

    //
    // TherapyGuide:
    // mreates main parts of the GUI
    public TherapyGuide()
    {
        mMainFrame = new JFrame("TherapyGuide");
        mLowerButtonPanel = new JPanel();
        mLowerButtonScrollPane = new JScrollPane(mLowerButtonPanel);
        mLowerButtonScrollPane.setPreferredSize(new Dimension(MAIN_FRAME_WIDTH,LOWER_BUTTON_SCROLL_PANE_HEIGHT));
    }

    //
    // main:
    // main method that calls all other relevant methods and customizes main JFrame
    public void main()
    {
        mMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mLowerButtonPanel.setLayout( new GridLayout() );

        // set flow layout for the frame
        this.getContentPane().setLayout(new FlowLayout());

        mLeftButtonPanel = new JPanel();
        mLeftButtonPanel.setLayout(new BoxLayout(mLeftButtonPanel, BoxLayout.PAGE_AXIS));
        init();

        mMainFrame.add(mLeftButtonPanel, BorderLayout.WEST);
        mMainFrame.setSize(MAIN_FRAME_WIDTH, MAIN_FRAME_HEIGHT);
        mMainFrame.setPreferredSize(new Dimension(MAIN_FRAME_WIDTH, MAIN_FRAME_HEIGHT));
        mMainFrame.setResizable(false);
        mMainFrame.pack();
        mMainFrame.setVisible(true);
    }

    //
    // addJButtonsToScrollPane:
    // method for adding BottomPanelButtons array to the scroll pane at bottom of the screen
    public void addJButtonsToScrollPane (JButton[] barg)
    {
        mLowerButtonPanel.removeAll();
        mLowerButtonScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        mLowerButtonScrollPane.setViewportBorder(new LineBorder(Color.RED));
        mMainFrame.add(mLowerButtonScrollPane, BorderLayout.SOUTH);

        int i = 0;

        for (i = 0; barg[i] != null; i++)
        {
            barg[i].setMinimumSize(new Dimension(LOWER_BUTTON_WIDTH, LOWER_BUTTON_WIDTH));
            barg[i].setPreferredSize(new Dimension(LOWER_BUTTON_WIDTH, LOWER_BUTTON_WIDTH));
            mLowerButtonPanel.add(barg[i]);
        }

        if (i <= 6)
        {
            mLowerButtonPanel.setLayout(new FlowLayout());
        }

        else
        {
            mLowerButtonPanel.setLayout(new GridLayout());
        }

        mMainFrame.setVisible(true);
    }

    //
    // actionPerformed:
    // action method that recognizes when any JButton is pressed and responds accordingly
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String action = ae.getActionCommand();
        String action1 = ae.getActionCommand();

        if (action.equals("Feet"))
        {
            addJButtonsToScrollPane(mFeetExercises);
        }

        else if (action.equals("Knee"))
        {
            addJButtonsToScrollPane(mKneeExercises);
        }

        else if (action.equals("Hip"))
        {
            addJButtonsToScrollPane(mHipExercises);
        }

        else if (action.equals("Trunk"))
        {
            addJButtonsToScrollPane(mTrunkExercises);
        }

        else if (action.equals("Hamstring"))
        {
            addJButtonsToScrollPane(mHamstringExercises);
        }

        // Formats and displays therapy procedures depending on what exercise is clicked.
        for (int i = 0; i < mTherapyProcedureButtons.length; i++)
        {
            if (action1.equals(mTherapyProcedureButtons[i].getTherapyName()))
            {
                BufferedImage image = null;

                try
                {
                    image = ImageIO.read(new File(sDataPath + mTherapyProcedureButtons[i].getTherapyImage()));
                }

                catch (IOException e)
                {
                    e.printStackTrace();
                }

                Image imageScaled = image.getScaledInstance(600, 400, java.awt.Image.SCALE_SMOOTH);
                JLabel sHeaderLabel = new JLabel(mTherapyProcedureButtons[i].getTherapyName(), JLabel.CENTER);
                sHeaderLabel.setFont(new Font("Calibri", Font.BOLD, 18));
                JLabel sImageLabel = new JLabel(new ImageIcon(imageScaled), JLabel.LEFT);
                JTextArea therapyTextArea = new JTextArea(5,75);
                therapyTextArea.setEditable(false);
                therapyTextArea.setFont(new Font("Calibri",Font.BOLD,14));
                //therapyTextArea.setBackground(Color.lightGray);
                therapyTextArea.insert(mTherapyProcedureButtons[i].getTherapyTextInfo(), 0);
                //sInfoLabel.setText("<html><p style=\"width:300px\">"+mLowerButtons[i].getTherapyTextInfo()+"</p></html>");
                JScrollPane textScrollPane = new JScrollPane(therapyTextArea);
                textScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                //textScrollPane.add(textScrollPane);
                JLabel sLabel = new JLabel("                     ");
                JPanel therapyPicturePanel = new JPanel(new BorderLayout());
                //therapyPicturePanel.setBackground(Color.DARK_GRAY);
                therapyPicturePanel.add(sLabel, BorderLayout.EAST);
                therapyPicturePanel.add(sHeaderLabel, BorderLayout.NORTH);
                therapyPicturePanel.add(sImageLabel, BorderLayout.CENTER);
                therapyPicturePanel.add(textScrollPane, BorderLayout.SOUTH);
                JPanel dPanel = new JPanel();
                dPanel.setPreferredSize(new Dimension(40, 40));
                mMainFrame.add(dPanel, BorderLayout.CENTER);
                mMainFrame.add(therapyPicturePanel, BorderLayout.EAST);
                mMainFrame.pack();
                mMainFrame.setVisible(true);
            }
        }
    }

    //
    // init:
    // Creates JButtons for left panel and adds the buttons to the action listener
    // Also sets correct names and icons for the lower panel JButtons
    public void init(){
        //Array of LeftPanelButton objects
        BodyPartButton mLeftButtons[] = {new BodyPartButton(null, "Feet",null),
                new BodyPartButton(null, "Knee", null),
                new BodyPartButton(null, "Hip", null),
                new BodyPartButton(null, "Trunk", null),
                new BodyPartButton(null,"Hamstring",null)};

        //For Loop for adding Left Panel Buttons
        JLabel mDummyLabel1 = new JLabel ("         ");
        JLabel mDummyLabel2 = new JLabel ("         ");
        JLabel mDummyLabel3 = new JLabel ("         ");
        JLabel mDummyLabel4 = new JLabel ("         ");
        mLeftButtonPanel.add(mDummyLabel1);
        mLeftButtonPanel.add(mDummyLabel2);

        for (int i = 0; i < mLeftButtons.length; i++)
        {
            if (mLeftButtons[i].getmBodyPartName().equals("Feet"))
            {
                mLeftButtons[i].setmButton(new JButton("Feet"));
            }

            if (mLeftButtons[i].getmBodyPartName().equals("Knee"))
            {
                mLeftButtons[i].setmButton(new JButton("Knee"));
            }

            if (mLeftButtons[i].getmBodyPartName().equals("Hip"))
            {
                mLeftButtons[i].setmButton(new JButton("Hip"));
            }

            if (mLeftButtons[i].getmBodyPartName().equals("Trunk"))
            {
                mLeftButtons[i].setmButton(new JButton("Trunk"));
            }

            if (mLeftButtons[i].getmBodyPartName().equals("Hamstring"))
            {
                mLeftButtons[i].setmButton(new JButton("Hamstring"));
            }

            mLeftButtons[i].getmButton().addActionListener(this);
            mLeftButtons[i].getmButton().setMinimumSize(new Dimension(LEFT_BUTTON_WIDTH, LEFT_BUTTON_HEIGHT));
            mLeftButtons[i].getmButton().setMaximumSize(new Dimension(LEFT_BUTTON_WIDTH, LEFT_BUTTON_HEIGHT));
            Dimension mLeftD = new Dimension(LEFT_BUTTON_WIDTH,LEFT_BUTTON_HEIGHT);
            mLeftButtons[i].getmButton().setPreferredSize(mLeftD);
            mLeftButtonPanel.add(mLeftButtons[i].getmButton());
        }

        mLeftButtonPanel.add(mDummyLabel3);
        mLeftButtonPanel.add(mDummyLabel4);

        //Index counters for Bodypart Arrays
        int fCount = 0;
        int kCount = 0;
        int hCount = 0;
        int tCount = 0;
        int lCount = 0;
        int haCount = 0;
        int hsCount = 0;

        for (int i = 0; i < mTherapyProcedureButtons.length; i++)
        {
            if (mTherapyProcedureButtons[i].getFeet()==true)
            {
                BufferedImage mImage = null;
                Image mImageScaled = null;

                try
                {
                    mImage = ImageIO.read(new File(sDataPath + mTherapyProcedureButtons[i].getIcon()));
                    mImageScaled = mImage.getScaledInstance(ICON_LENGTH, ICON_LENGTH, Image.SCALE_DEFAULT);
                }

                catch (IOException e)
                {
                    e.printStackTrace();
                }

                mTherapyProcedureButtons[i].setButton(new JButton(new ImageIcon(mImageScaled)));
                mFeetExercises[fCount] = mTherapyProcedureButtons[i].getButton();
                mTherapyProcedureButtons[i].getButton().addActionListener(this);
                mTherapyProcedureButtons[i].getButton().setActionCommand(mTherapyProcedureButtons[i].getTherapyName());
                fCount++;
            }

            if (mTherapyProcedureButtons[i].getKnee()==true)
            {
                BufferedImage mImage = null;
                Image mImageScaled = null;

                try
                {
                    mImage = ImageIO.read(new File(sDataPath + mTherapyProcedureButtons[i].getIcon()));
                    mImageScaled = mImage.getScaledInstance(ICON_LENGTH, ICON_LENGTH, Image.SCALE_DEFAULT);
                }

                catch (IOException e)
                {
                    e.printStackTrace();
                }

                mTherapyProcedureButtons[i].setButton(new JButton(new ImageIcon(mImageScaled)));
                mKneeExercises[kCount] = mTherapyProcedureButtons[i].getButton();
                mTherapyProcedureButtons[i].getButton().addActionListener(this);
                mTherapyProcedureButtons[i].getButton().setActionCommand(mTherapyProcedureButtons[i].getTherapyName());
                kCount++;
            }

            if (mTherapyProcedureButtons[i].getHip()==true)
            {
                BufferedImage mImage = null;
                Image mImageScaled = null;

                try
                {
                    mImage = ImageIO.read(new File(sDataPath + mTherapyProcedureButtons[i].getIcon()));
                    mImageScaled = mImage.getScaledInstance(ICON_LENGTH, ICON_LENGTH, Image.SCALE_DEFAULT);
                }

                catch (IOException e)
                {
                    e.printStackTrace();
                }

                mTherapyProcedureButtons[i].setButton(new JButton(new ImageIcon(mImageScaled)));
                mHipExercises[hCount] = mTherapyProcedureButtons[i].getButton();
                mTherapyProcedureButtons[i].getButton().addActionListener(this);
                mTherapyProcedureButtons[i].getButton().setActionCommand(mTherapyProcedureButtons[i].getTherapyName());
                hCount++;
            }

            if (mTherapyProcedureButtons[i].getTrunk()==true)
            {
                BufferedImage mImage = null;
                Image mImageScaled = null;

                try
                {
                    mImage = ImageIO.read(new File(sDataPath + mTherapyProcedureButtons[i].getIcon()));
                    mImageScaled = mImage.getScaledInstance(ICON_LENGTH, ICON_LENGTH, Image.SCALE_DEFAULT);
                }

                catch (IOException e)
                {
                    e.printStackTrace();
                }

                mTherapyProcedureButtons[i].setButton(new JButton(new ImageIcon(mImageScaled)));
                mTrunkExercises[tCount] = mTherapyProcedureButtons[i].getButton();
                mTherapyProcedureButtons[i].getButton().addActionListener(this);
                mTherapyProcedureButtons[i].getButton().setActionCommand(mTherapyProcedureButtons[i].getTherapyName());
                tCount++;
            }

            if (mTherapyProcedureButtons[i].getLeg()==true)
            {
                BufferedImage mImage = null;
                Image mImageScaled = null;

                try
                {
                    mImage = ImageIO.read(new File(sDataPath + mTherapyProcedureButtons[i].getIcon()));
                    mImageScaled = mImage.getScaledInstance(ICON_LENGTH, ICON_LENGTH, Image.SCALE_DEFAULT);
                }

                catch (IOException e)
                {
                    e.printStackTrace();
                }

                mTherapyProcedureButtons[i].setButton(new JButton(new ImageIcon(mImageScaled)));
                mLegExercises[lCount] = mTherapyProcedureButtons[i].getButton();
                mTherapyProcedureButtons[i].getButton().addActionListener(this);
                mTherapyProcedureButtons[i].getButton().setActionCommand(mTherapyProcedureButtons[i].getTherapyName());
                lCount++;
            }

            if (mTherapyProcedureButtons[i].getHand()==true)
            {
                BufferedImage mImage = null;
                Image mImageScaled = null;

                try
                {
                    mImage = ImageIO.read(new File(sDataPath + mTherapyProcedureButtons[i].getIcon()));
                    mImageScaled = mImage.getScaledInstance(ICON_LENGTH, ICON_LENGTH, Image.SCALE_DEFAULT);
                }

                catch (IOException e)
                {
                    e.printStackTrace();
                }

                mTherapyProcedureButtons[i].setButton(new JButton(new ImageIcon(mImageScaled)));
                mHandExercises[haCount] = mTherapyProcedureButtons[i].getButton();
                mTherapyProcedureButtons[i].getButton().addActionListener(this);
                mTherapyProcedureButtons[i].getButton().setActionCommand(mTherapyProcedureButtons[i].getTherapyName());
                haCount++;
            }

            if (mTherapyProcedureButtons[i].getHamstring()==true)
            {
                BufferedImage mImage = null;
                Image mImageScaled = null;

                try
                {
                    mImage = ImageIO.read(new File(sDataPath + mTherapyProcedureButtons[i].getIcon()));
                    mImageScaled = mImage.getScaledInstance(ICON_LENGTH, ICON_LENGTH, Image.SCALE_DEFAULT);
                }

                catch (IOException e)
                {
                    e.printStackTrace();
                }

                mTherapyProcedureButtons[i].setButton(new JButton(new ImageIcon(mImageScaled)));
                mHamstringExercises[hsCount] = mTherapyProcedureButtons[i].getButton();
                mTherapyProcedureButtons[i].getButton().addActionListener(this);
                mTherapyProcedureButtons[i].getButton().setActionCommand(mTherapyProcedureButtons[i].getTherapyName());
                hsCount++;
            }
        }
    }

    //Array of TherapyProcedureButton objects that holds identifying information
    //about each physical therapy exercise
    TherapyProcedureButton mTherapyProcedureButtons[] = {new TherapyProcedureButton(null,"HIP KNEE - 38 Stretching: Hamstring",
            true, true, true, false, false, false, true,"hip.knee.38.I.jpg",
            "hip.knee.38.G.jpg","Supporting right thigh behind knee, slowly straighten knee until a" +
            " stretch is felt in back of thigh. Hold for 60 seconds.\n\nRepeat 3 times per set. Do 1 set per session." +
            "\nDo 1-2 sessions per day."),
            new TherapyProcedureButton(null,"HIP KNEE - 48 Piriformis",
                    false,true, true,false,false,false,true,"hip.knee.48.I.jpg",
                    "hip.knee.48.G.jpg", "Cross legs with right leg on top and gently pull other knee " +
                    "toward\nchest until stretch is felt in buttocks/hip of top leg. Hold for 30 seconds.\n\nRepeat 3 times per set." +
                    " Do 1 set per session.\nDo 1-2 sessions per day."),
            new TherapyProcedureButton(null,"ANKLE FOOT - 18 ROM: Plantar",
                    true, false, false, false, false, false, false,"ankle.foot.18.I.jpg",
                    "ankle.foot.18.G.jpg", "Pull up foot and hold for 30 seconds. Repeat 3 times on\neach foot " +
                    "2 times per day."),
            new TherapyProcedureButton(null,"HIP KNEE - 54 Strengthening: Hip Abductor",
                    false, true, true, false, false, false,false, "hip.knee.54.I.jpg",
                    "hip.knee.54.G.jpg", "With resistance band looped around legs above knees, push thighs apart." +
                    "\n\nRepeat 25 times per set. Do 1 set per session.\nDo 1-2 sessions per day."),
            new TherapyProcedureButton(null,"HIP KNEE - 16 Strengthening: Hip Adduction",
                    false, true, true, false, false, false, false,"hip.knee.16.I.jpg",
                    "hip.knee.16.G.jpg", "With ball or pillow between knees, squeeze knees together. Hold for " +
                    "5 seconds.\n\nRepeat 20 times per set. Do 1 set per session.\nDo 1-2 sessions per day."),
            new TherapyProcedureButton(null,"TRUNK STABILITY - 9 Bridging",
                    false, false, false, true,false, false, false,"trunk.stability.9.I.jpg",
                    "trunk.stability.9.G.jpg", "Slowly raise buttocks from floor whilst keeping stomach tight." +
                    "\n\nRepeat 10 times per set. Do 1 set per session.\nDo 1-2 sessions per day."),
            new TherapyProcedureButton(null,"HIP - 28 Stretching: Flexors",
                    false, false, true, false, false, false, false,"hip.28.I.jpg",
                    "hip.28.G.jpg", "Lie on edge of surface and with one leg on floor and pull " +
                    "other leg's knee towards chest.\n\nHold for 30 seconds.\nDo 3 reps per set, 1 set per day, 4-7 days per week."),
            new TherapyProcedureButton(null,"KNEE - 35 Quadriceps",
                    false, true, false, false, false, false, false,"knee.35.I.jpg",
                    "knee.35.G.jpg", "Place strap around ankle and bring ankle towards buttocks. " + "" +
                    "Hold for 15 seconds.\n\nDo 3 reps per set, 1 set per day, 4-7 days per week."),
            new TherapyProcedureButton(null,"ANKLE - 36 Stretching: Dorsiflexion ",
                    true, false, false, false, false, false, false,"ankle.36.I.jpg",
                    "ankle.36.G.jpg", "While sitting, place strap around foot and pull foot toward body. Hold " +
                    "for 30 seconds.\n\nDo 3 reps per set, 1 set per day, 4-7 days per week."),
            new TherapyProcedureButton(null,"HIP - 27 External Rotation",
                    false, false, true, false, false, false, false,"hip.27.I.jpg",
                    "hip.27.G.jpg", "Sit at edge of surface and cross one leg and gently press " +
                    "on knee. Hold for 30 seconds.\n\nDo 3 reps per set, 1 set per day, 4-7 days per week."),
            new TherapyProcedureButton(null,"TRUNK STABILITY - 4 Isometric Abdominal",
                    false, false, false, true,false, false, false,"trunk.stability.4.I.jpg",
                    "trunk.stability.4.G.jpg", "Lying on back with knees bent and tighten stomach by pressing elbows " +
                    "down. Hold for 5 seconds.\n\nRepeat 10 times per set. Do 1 set per session.\nDo 2 sessions per day."),
            new TherapyProcedureButton(null,"TRUNK STABILITY - 6 Bent Leg Lift",
                    false, false, false, true,false, false, false,"trunk.stability.6.I.jpg",
                    "trunk.stability.6.G.jpg", "Tighten stomach and slowly raise right leg from floor. Hold 3 seconds." +
                    "\n\nRepeat 10 times per set. Do 2 sets per session.\nDo 1 session per day."),
            new TherapyProcedureButton(null,"TRUNK STABILITY - 8 Heel Walk",
                    false, false, false, true,false, false, false,"trunk.stability.8.I.jpg",
                    "trunk.stability.8.G.jpg", "Tighten stomach and slowly walk feet forward in short steps until legs are " +
                    "nearly straight.\n\nRepeat 10 times per set. Do 1 set per session.\nDo 1 session per day."),
            new TherapyProcedureButton(null,"TRUNK STABILITY - 12 Straight Leg Raise",
                    false, false, false, true,false, false, false,"trunk.stability.12.I.jpg",
                    "trunk.stability.12.G.jpg", "Tighten stomach and slowly raise locked right leg 6 inches from floor." +
                    "\n\nRepeat 10 times per set. Do 1 set per session.\nDo 1 session per day."),
            new TherapyProcedureButton(null,"TRUNK STABILITY - 7 Combination",
                    false, false, false, true,false, false, false,"trunk.stability.7.I.jpg",
                    "trunk.stability.7.G.jpg", "Tighten stomach and slowly raise left leg and lower opposite arm over head." +
                    "\n\nRepeat 10 times per day. Do 1 set per session.\nDo 1 session per day."),
            new TherapyProcedureButton(null,"HIP/KNEE - 21 Strengthening: Hip Abduction",
                    false, true, true, false,false, false, false,"hip.knee.21.I.jpg",
                    "hip.knee.21.G.jpg", "Tighten muscles on front of left thigh, then lift leg 6 inches from surface while " +
                    "keeping knee locked.\n\nRepeat 10 times per set. Do 1 set per session.\nDo 1 session per day."),
    };
}


