package com.newFrame;

import com.formdev.flatlaf.FlatDarkLaf;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class frame extends javax.swing.JFrame {

    boolean Con;
    JTextField marks[];
    String Subjects[] = {"English Language", "Sinhala / Tamil Language", "Religion – Buddhism / Christianity\n" + "Catholicism / Islam / Hinduism", "Mathematics", "Science", "History", "Citizenship Education / BAS", "Health & Physical Education", "ICT", "Art / English Literature / Western\n" + " M. / Eastern M./ Kandyan Dancing ", "French", "Geography"};
    public static String SaveDirectory = "";

    public frame() {
        this.marks = new JTextField[]{eng, plan, religion, maths, science, history, civic, health, it, art, french, geo};
        initComponents();
    }

    public Image Image(String ImagePath, float x, float y, float Width, float Height) {
        Image img = null;
        if (!ImagePath.equals("Not Selected")) {
            try {
                img = Image.getInstance(ImagePath);
                img.scaleAbsolute(Width, Height);
                img.setAbsolutePosition(x, y);
            } catch (BadElementException | IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        return img;
    }

    public void Document(String Path_Name) {
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + Path_Name);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public PdfPCell getCell(String text) {
        Font newfont = new Font(Font.FontFamily.TIMES_ROMAN, 11, 1, new BaseColor(0, 0, 0));
        PdfPCell HCell = new PdfPCell();
        Paragraph p = new Paragraph(text, newfont);
        p.setAlignment(Element.ALIGN_CENTER);
        HCell.addElement(p);
        return HCell;
    }

    public double getTotal(String Marks[]) {
        double Total = 0;
        for (String mark : Marks) {
            int Imark = 0;
            try {
                Imark = Integer.parseInt(mark);
            } catch (NumberFormatException e) {
            }
            Total = Total + Imark;
        }
        return Total;
    }

    public double getAverage(String Marks[]) {
        double Average;
        Average = getTotal(Marks) / (int) NoS.getValue();
        System.out.println(getTotal(Marks) +" / "+ (int) NoS.getValue() +" = "+Average);
        return Average;
    }

    public JTextField[] getTexts() {
        JTextField[] mark = {eng, plan, religion, maths, science, history, civic, health, it, art, french, geo};
        return mark;
    }

    public void RF(KeyEvent evt, JComponent com) {
        char key = evt.getKeyChar();
        JTextField[] mark = getTexts();
        boolean isTextF = false;
        for (JTextField m : mark) {
            if (m.equals(com)) {
                isTextF = true;
            }
        }
        if (isTextF) {
            if (Character.isDigit(key) || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_BACK_SPACE) {

            } else {
                evt.consume();
            }
        }
        if (key == KeyEvent.VK_ENTER) {
            JComponent com1 = (JComponent) jPanel1.findComponentAt(com.getX(), com.getY() + 30);
            System.out.println(com1);
            com1.requestFocus();
        }
        Con = false;
    }

    public void setTotAvr(KeyEvent evt, JTextField Tf) {
        JTextField[] Cmarks = getTexts();
        String Marks[] = new String[Cmarks.length];
        for (int i = 0; i < Cmarks.length; i++) {
            System.out.println(i + " = " + Cmarks[i].getText());
            Marks[i] = Cmarks[i].getText();
        }
        avr.setText(String.format("%.2f", getAverage(Marks)));
        tot.setText(Double.toString(getTotal(Marks)));
    }

    public Object getSubs() {
        return 9;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        grade = new javax.swing.JTextField();
        geo = new javax.swing.JTextField();
        first = new javax.swing.JTextField();
        french = new javax.swing.JTextField();
        art = new javax.swing.JTextField();
        it = new javax.swing.JTextField();
        health = new javax.swing.JTextField();
        civic = new javax.swing.JTextField();
        eng = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        plan = new javax.swing.JTextField();
        maths = new javax.swing.JTextField();
        religion = new javax.swing.JTextField();
        science = new javax.swing.JTextField();
        history = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        teacher1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        clear = new javax.swing.JButton();
        grade1 = new javax.swing.JTextField();
        teacher2 = new javax.swing.JTextField();
        path = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Message = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tot = new javax.swing.JLabel();
        avr = new javax.swing.JLabel();
        NoS = new javax.swing.JSpinner();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Digital Print");
        setBackground(new java.awt.Color(0, 204, 204));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("English");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Sinhala / tamil");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Religion");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Mathematics");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Science");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("History");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Citizenship Education / BAS");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Health & Physical Education ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("ICT");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setText("Art / English Lit / Music/Dancing ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 220, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setText("Teacher");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Grade :");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setText("French");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setText("Geography");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("Name of the Student :");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeActionPerformed(evt);
            }
        });
        grade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gradeKeyPressed(evt);
            }
        });
        jPanel1.add(grade, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 70, -1));

        geo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                geoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                geoKeyTyped(evt);
            }
        });
        jPanel1.add(geo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 90, -1));

        first.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                firstKeyTyped(evt);
            }
        });
        jPanel1.add(first, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 180, -1));

        french.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                frenchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                frenchKeyTyped(evt);
            }
        });
        jPanel1.add(french, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 90, -1));

        art.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                artKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                artKeyTyped(evt);
            }
        });
        jPanel1.add(art, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 90, -1));

        it.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                itKeyTyped(evt);
            }
        });
        jPanel1.add(it, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 90, -1));

        health.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                healthKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                healthKeyTyped(evt);
            }
        });
        jPanel1.add(health, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 90, -1));

        civic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                civicActionPerformed(evt);
            }
        });
        civic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                civicKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                civicKeyTyped(evt);
            }
        });
        jPanel1.add(civic, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 90, -1));

        eng.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                engKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                engKeyTyped(evt);
            }
        });
        jPanel1.add(eng, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 90, -1));

        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameKeyTyped(evt);
            }
        });
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 185, -1));

        plan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                planKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                planKeyTyped(evt);
            }
        });
        jPanel1.add(plan, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 90, -1));

        maths.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mathsKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mathsKeyTyped(evt);
            }
        });
        jPanel1.add(maths, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 90, -1));

        religion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                religionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                religionKeyTyped(evt);
            }
        });
        jPanel1.add(religion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 90, -1));

        science.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                scienceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                scienceKeyTyped(evt);
            }
        });
        jPanel1.add(science, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 90, -1));

        history.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                historyKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                historyKeyTyped(evt);
            }
        });
        jPanel1.add(history, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 90, -1));

        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton1.setText("PRINT THE FORM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 730, -1));

        teacher1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                teacher1KeyTyped(evt);
            }
        });
        jPanel1.add(teacher1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 180, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel16.setText("Save Path");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 220, -1));

        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel1.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, -1, -1));

        grade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grade1ActionPerformed(evt);
            }
        });
        grade1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                grade1KeyPressed(evt);
            }
        });
        jPanel1.add(grade1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 60, -1));

        teacher2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                teacher2KeyTyped(evt);
            }
        });
        jPanel1.add(teacher2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 180, -1));

        path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathActionPerformed(evt);
            }
        });
        path.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pathKeyTyped(evt);
            }
        });
        jPanel1.add(path, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, 400, -1));

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel17.setText("Percentage of the First inthe class");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 220, -1));

        jButton3.setText("PATH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, -1, -1));

        jButton4.setText("OPEN");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 562, -1, -1));

        Message.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(Message, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 610, 20));
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, -1, -1));

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel19.setText("AVERAGE   :");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 410, -1, -1));
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, -1, -1));

        jLabel22.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel22.setText("NO. OF SUBJECTS :");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 25, -1, -1));

        tot.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tot.setText("TOTAL");
        jPanel1.add(tot, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, 160, -1));

        avr.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        avr.setText("AVERAGE");
        jPanel1.add(avr, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 160, -1));

        NoS.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        NoS.setValue(getSubs());
        jPanel1.add(NoS, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, -1, -1));

        jLabel23.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel23.setText("TOTAL        :");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 761, 600));

        setSize(new java.awt.Dimension(777, 634));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Document doc = new Document(PageSize.A4, 40, 40, 40, 40);
        JTextField[] marks = getTexts();
        String Marks[] = new String[marks.length];
        Image logo = Image("src\\Images\\left.png", 30, 708, 104, 104);
        File file = new File(SaveDirectory + "\\" + name.getText() + ".pdf");
        Image health = Image("src\\Images\\right.png", 440, 708, 95, 95);
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 11, 1, BaseColor.GREEN);
        Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 11, 1, BaseColor.RED);
        Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 11, 1, new BaseColor(222, 191, 28));
        Font newfont = new Font(Font.FontFamily.TIMES_ROMAN, 12, 1, new BaseColor(0, 0, 0));
        for (int i = 0; i < marks.length; i++) {
            System.out.println(i + " = " + marks[i].getText());
            Marks[i] = marks[i].getText();
        }
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(file));
            doc.open();
            doc.add(logo);
            doc.add(health);
            Paragraph p = new Paragraph("SCHOOL NAME", font);
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);
            p = new Paragraph("MIDDLE AND SENIOR SCHOOL", font1);
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);
            p = new Paragraph("TERM END EVALUATION - DIGITAL REPORT", font2);
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);
            p = new Paragraph("JULY 2021 - 2nd TERM\n\n\n", font);
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);
            float Widths[] = {310f, 90f, 90f, 210f};
            PdfPTable Table = new PdfPTable(Widths);
            PdfPCell cell2 = new PdfPCell();
            cell2.setColspan(4);
            cell2.addElement(new Paragraph("Name  " + name.getText(), newfont));
            Table.addCell(cell2);
            Table.addCell(new Paragraph("Grade  " + grade.getText(), newfont));
            PdfPCell cellx = new PdfPCell();
            cellx.setColspan(3);
            cellx.addElement(new Paragraph("Attendents............out of..........."));
            Table.addCell(cellx);
            Table.addCell(getCell("Subject"));
            Table.addCell(getCell("Marks"));
            Table.addCell(getCell("Class\nAverage"));
            Table.addCell(getCell("Remarks of the Teacher"));
            for (int Index = 0; Index < marks.length; Index++) {
                Table.addCell(Subjects[Index]);
                Table.addCell(String.format("%03d", Integer.parseInt(Marks[Index])));
                Table.addCell("");
                Table.addCell("");
            }
            Table.addCell(getCell("TOTAL IN EVALUATIONS"));
            Table.addCell(getCell(String.format("%.0f", getTotal(Marks))));
            Table.addCell("");
            Table.addCell("");
            Table.addCell(getCell("PERCENTAGE IN EVALUATIONS"));
            Table.addCell(getCell(String.format("%.2f", getAverage(Marks))));
            Table.addCell("");
            Table.addCell("");
            Table.addCell(getCell("Percentage of first in the Class"));
            Table.addCell(first.getText());
            Table.addCell("");
            Table.addCell("");
            PdfPCell cell = new PdfPCell();
            cell.setColspan(4);
            cell.addElement(new Paragraph("General Progress and Conduct"));
            Table.addCell(cell);
            doc.add(Table);
            float Widths1[] = {200f, 305f};
            PdfPTable Table1 = new PdfPTable(Widths1);
            Table1.addCell(getCell("Class Teacher\n"));
            Table1.addCell(teacher1.getText());
            Table1.addCell(getCell("Parent\n"));
            Table1.addCell("");
            PdfPCell cell1 = new PdfPCell();
            cell1.setColspan(2);
            cell1.addElement(new Paragraph("Term 2 of 2021 ends on 13th Aug 2021 and Term 3 of 2021 commences from 1st Sept 2021 ", font));
            Table1.addCell(cell1);
            doc.add(Table1);
            doc.add(new Paragraph("Please note that these evaluations were done to assess the students’ knowledge subject wise as they were out of \"live teaching\"."));
            doc.add(new Paragraph("\nTo parent,\n\n" + "Kindly take a printout of the report, sign it and send it to the class teacher on or before the 1st of September.", newfont));
            doc.close();
            Message.setText("PDF Saved!\nClick to Open!");
            Con = true;
            clear.requestFocus();
        } catch (DocumentException | FileNotFoundException e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void gradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gradeActionPerformed

    private void gradeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gradeKeyPressed
        RF(evt, grade);         // TODO add your handling code here:
    }//GEN-LAST:event_gradeKeyPressed

    private void nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyTyped
        RF(evt, name);        // TODO add your handling code here:
    }//GEN-LAST:event_nameKeyTyped

    private void engKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_engKeyTyped
        RF(evt, eng);        // TODO add your handling code here:
    }//GEN-LAST:event_engKeyTyped

    private void planKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_planKeyTyped
        RF(evt, plan);        // TODO add your handling code here:
    }//GEN-LAST:event_planKeyTyped

    private void religionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_religionKeyTyped
        RF(evt, religion);        // TODO add your handling code here:
    }//GEN-LAST:event_religionKeyTyped

    private void mathsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mathsKeyTyped
        RF(evt, maths);        // TODO add your handling code here:
    }//GEN-LAST:event_mathsKeyTyped

    private void scienceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_scienceKeyTyped
        RF(evt, science);        // TODO add your handling code here:
    }//GEN-LAST:event_scienceKeyTyped

    private void historyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_historyKeyTyped
        RF(evt, history);        // TODO add your handling code here:
    }//GEN-LAST:event_historyKeyTyped

    private void civicKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_civicKeyTyped
        RF(evt, civic);        // TODO add your handling code here:
    }//GEN-LAST:event_civicKeyTyped

    private void healthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_healthKeyTyped
        RF(evt, health);        // TODO add your handling code here:
    }//GEN-LAST:event_healthKeyTyped

    private void itKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itKeyTyped
        RF(evt, it);        // TODO add your handling code here:
    }//GEN-LAST:event_itKeyTyped

    private void artKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_artKeyTyped
        RF(evt, art);        // TODO add your handling code here:
    }//GEN-LAST:event_artKeyTyped

    private void frenchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_frenchKeyTyped
        RF(evt, french);        // TODO add your handling code here:
    }//GEN-LAST:event_frenchKeyTyped

    private void geoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_geoKeyTyped
        RF(evt, geo);        // TODO add your handling code here:
    }//GEN-LAST:event_geoKeyTyped

    private void firstKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstKeyTyped
        RF(evt, first);        // TODO add your handling code here:
    }//GEN-LAST:event_firstKeyTyped

    private void teacher1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teacher1KeyTyped
        RF(evt, teacher1);
    }//GEN-LAST:event_teacher1KeyTyped

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        JTextField marks[] = getTexts();
        for (JTextField m : marks) {
            m.setText("");
        }
        grade.setText(grade1.getText());
        teacher1.setText(teacher2.getText());
        name.setText("");
        path.setText(SaveDirectory);
        name.requestFocus();
    }//GEN-LAST:event_clearActionPerformed

    private void grade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grade1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grade1ActionPerformed

    private void grade1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_grade1KeyPressed
        grade.setText(grade1.getText());
    }//GEN-LAST:event_grade1KeyPressed

    private void teacher2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teacher2KeyTyped
        teacher1.setText(teacher2.getText());
    }//GEN-LAST:event_teacher2KeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Save Location");
        jfc.setApproveButtonText("SELECT PATH");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (!"".equals(SaveDirectory)) {
            jfc.setCurrentDirectory(new File(SaveDirectory));
        }
        int approve = jfc.showSaveDialog(null);
        switch (approve) {
            case JFileChooser.APPROVE_OPTION:
                System.out.println("approve = " + approve);
                SaveDirectory = jfc.getSelectedFile().toPath().toString();
                path.setText(SaveDirectory);
                jfc.setVisible(false);
                break;
            case JFileChooser.CANCEL_OPTION:
                jfc.setVisible(false);
                break;
            case JFileChooser.ERROR_OPTION:
                jfc.setVisible(false);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (Con) {
            Document(SaveDirectory + "\\" + name.getText() + ".pdf");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathActionPerformed

    }//GEN-LAST:event_pathActionPerformed

    private void pathKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pathKeyTyped
        RF(evt, path);
    }//GEN-LAST:event_pathKeyTyped

    private void engKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_engKeyReleased
        setTotAvr(evt, eng);        // TODO add your handling code here:
    }//GEN-LAST:event_engKeyReleased

    private void planKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_planKeyReleased
        setTotAvr(evt, plan);        // TODO add your handling code here:
    }//GEN-LAST:event_planKeyReleased

    private void religionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_religionKeyReleased
        setTotAvr(evt, religion);        // TODO add your handling code here:
    }//GEN-LAST:event_religionKeyReleased

    private void mathsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mathsKeyReleased
        setTotAvr(evt, maths);         // TODO add your handling code here:
    }//GEN-LAST:event_mathsKeyReleased

    private void scienceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_scienceKeyReleased
        setTotAvr(evt, science);          // TODO add your handling code here:
    }//GEN-LAST:event_scienceKeyReleased

    private void historyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_historyKeyReleased
        setTotAvr(evt, history);          // TODO add your handling code here:
    }//GEN-LAST:event_historyKeyReleased

    private void civicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_civicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_civicActionPerformed

    private void civicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_civicKeyReleased
        setTotAvr(evt, civic);          // TODO add your handling code here:
    }//GEN-LAST:event_civicKeyReleased

    private void healthKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_healthKeyReleased
        setTotAvr(evt, health);          // TODO add your handling code here:
    }//GEN-LAST:event_healthKeyReleased

    private void itKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itKeyReleased
        setTotAvr(evt, it);          // TODO add your handling code here:
    }//GEN-LAST:event_itKeyReleased

    private void artKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_artKeyReleased
        setTotAvr(evt, art);          // TODO add your handling code here:
    }//GEN-LAST:event_artKeyReleased

    private void frenchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_frenchKeyReleased
        setTotAvr(evt, french);          // TODO add your handling code here:
    }//GEN-LAST:event_frenchKeyReleased

    private void geoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_geoKeyReleased
        setTotAvr(evt, geo);          // TODO add your handling code here:
    }//GEN-LAST:event_geoKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {//"javax.swing.plaf.nimbus.NimbusLookAndFeel"
            JOptionPane.showMessageDialog(null, e);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Message;
    private javax.swing.JSpinner NoS;
    private javax.swing.JTextField art;
    private javax.swing.JLabel avr;
    private javax.swing.JTextField civic;
    private javax.swing.JButton clear;
    private javax.swing.JTextField eng;
    private javax.swing.JTextField first;
    private javax.swing.JTextField french;
    private javax.swing.JTextField geo;
    private javax.swing.JTextField grade;
    private javax.swing.JTextField grade1;
    private javax.swing.JTextField health;
    private javax.swing.JTextField history;
    private javax.swing.JTextField it;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField maths;
    private javax.swing.JTextField name;
    private javax.swing.JTextField path;
    private javax.swing.JTextField plan;
    private javax.swing.JTextField religion;
    private javax.swing.JTextField science;
    private javax.swing.JTextField teacher1;
    private javax.swing.JTextField teacher2;
    private javax.swing.JLabel tot;
    // End of variables declaration//GEN-END:variables
}
