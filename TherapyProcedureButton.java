//
// Name:    TherapyProcedureButton.java - Data class that hold information for physical therapy exercises
// Type:    Java source file
// Program: TherapyGuide - Physical Therapy Administer
// Author:  Aryan Samal
// Version: 1.0
//
// Copyright 2020, This software is confidential and proprietary to the author. Copy, download,
// and reproduction of the software in any form is prohibited unless for academic purposes.
//

import javax.swing.*;

//
// TherapyProcedureButton Class:
// Data class that holds information for each therapy exercise
class TherapyProcedureButton {

    // defines
    private JButton mButton;
    private String mTherapyName;
    private Boolean mFeet;
    private Boolean mKnee;
    private Boolean mHip;
    private Boolean mTrunk;
    private Boolean mLeg;
    private Boolean mHand;
    private Boolean mHamstring;
    private String mIcon;
    private String mTherapyImage;
    private String mTherapyTextInfo;

    //
    // TherapyProcedureButton:
    // Constructor for TherapyProcedureButton class that takes in a number of identifying information
    public TherapyProcedureButton(JButton pButton,
                                  String pTherapyName,
                                  Boolean pFeet,
                                  Boolean pKnee,
                                  Boolean pHip,
                                  Boolean pTrunk,
                                  Boolean pLeg,
                                  Boolean pHand,
                                  Boolean pHamstring,
                                  String pIcon,
                                  String pTherapyImage,
                                  String pTherapyTextInfo)
    {
        mButton = pButton;
        mTherapyName = pTherapyName;
        mFeet = pFeet;
        mKnee = pKnee;
        mHip = pHip;
        mTrunk = pTrunk;
        mLeg = pLeg;
        mHand = pHand;
        mHamstring = pHamstring;
        mIcon = pIcon;
        mTherapyImage = pTherapyImage;
        mTherapyTextInfo = pTherapyTextInfo;
    }

    public JButton getButton()
    {
        return mButton;
    }

    public void setButton(JButton button)
    {
        this.mButton = button;
    }

    public String getTherapyTextInfo()
    {
        return mTherapyTextInfo;
    }

    public Boolean getFeet()
    {
        return mFeet;
    }

    public Boolean getHand()
    {
        return mHand;
    }

    public Boolean getLeg()
    {
        return mLeg;
    }

    public Boolean getTrunk()
    {
        return mTrunk;
    }

    public String getTherapyName()
    {
        return mTherapyName;
    }

    public Boolean getHip()
    {
        return mHip;
    }

    public String getTherapyImage()
    {
        return mTherapyImage;
    }

    public String getIcon()
    {
        return mIcon;
    }

    public Boolean getKnee()
    {
        return mKnee;
    }

    public boolean getHamstring()
    {
        return mHamstring;
    }

}

