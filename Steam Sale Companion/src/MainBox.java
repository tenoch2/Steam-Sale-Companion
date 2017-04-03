
import com.github.goive.steamapi.SteamApi;
import com.github.goive.steamapi.data.SteamApp;
import java.util.ArrayList;
import java.util.Optional;
import javax.swing.DefaultListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michael
 */
public class MainBox extends javax.swing.JFrame {

    //Creates variables steam (the steam API), game (a steam App), and the list 
    //of Steam Apps for prccessing
    SteamApi steam; 
    SteamApp game;
    ArrayList<SteamApp> gameList;
    DefaultListModel<String> lm;
    
    /**
     * Creates new form MainBox, initializes steam and gameList
     * and also adds change listeners to the sliders
     */
    public MainBox() {
        
        initComponents();
        steam = new SteamApi("US");
        priceSlider.addChangeListener(new SlideListener(priceField, priceSlider));
        saleSlider.addChangeListener(new SlideListener(saleField, saleSlider));
        criticSlider.addChangeListener(new SlideListener(criticField, criticSlider));
        priceField.addKeyListener(new TextFieldListener(priceField, priceSlider));
        saleField.addKeyListener(new TextFieldListener(saleField, saleSlider));
        criticField.addKeyListener(new TextFieldListener(criticField, criticSlider));
        currentGame.setMainBox(this);
        gameList = new ArrayList();
        lm = new DefaultListModel();
        addedGames.setModel(lm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addedGames = new javax.swing.JList();
        viewBtn = new javax.swing.JButton();
        clearGameListBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        inputPanel = new javax.swing.JPanel();
        gameLabel = new javax.swing.JLabel();
        gameInputField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        currentGamePanel = new javax.swing.JPanel();
        currentGame = new GamePanel();
        jPanel2 = new javax.swing.JPanel();
        buttonPanel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        outputPanel = new javax.swing.JPanel();
        priceSlider = new javax.swing.JSlider();
        priceLable = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        SaleLabel = new javax.swing.JLabel();
        saleSlider = new javax.swing.JSlider();
        saleField = new javax.swing.JTextField();
        MetaCritLAble = new javax.swing.JLabel();
        criticSlider = new javax.swing.JSlider();
        criticField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultTextArea = new javax.swing.JTextArea();
        calculateBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Steam-Sale Companion");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 0, 0));

        addedGames.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        addedGames.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        addedGames.setToolTipText("");
        jScrollPane1.setViewportView(addedGames);

        viewBtn.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        viewBtn.setText("View");
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });

        clearGameListBtn.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        clearGameListBtn.setText("Clear");
        clearGameListBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearGameListBtnActionPerformed(evt);
            }
        });

        removeBtn.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        removeBtn.setText("Remove");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        inputPanel.setBackground(new java.awt.Color(255, 255, 255));

        gameLabel.setFont(new java.awt.Font("Serif", 0, 20)); // NOI18N
        gameLabel.setText("Game name:");

        gameInputField.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        gameInputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameInputFieldActionPerformed(evt);
            }
        });

        searchButton.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        searchButton.setText("Search");
        searchButton.setMaximumSize(new java.awt.Dimension(81, 35));
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gameInputField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gameInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        currentGamePanel.setBackground(new java.awt.Color(255, 255, 255));
        currentGamePanel.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                currentGamePanelComponentAdded(evt);
            }
        });

        javax.swing.GroupLayout currentGamePanelLayout = new javax.swing.GroupLayout(currentGamePanel);
        currentGamePanel.setLayout(currentGamePanelLayout);
        currentGamePanelLayout.setHorizontalGroup(
            currentGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentGamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentGame, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        currentGamePanelLayout.setVerticalGroup(
            currentGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, currentGamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentGame, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentGamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clearGameListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(110, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(inputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentGamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearGameListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jPanel2.setMaximumSize(new java.awt.Dimension(500, 3500));

        buttonPanel.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jButton2.setText("Import");

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addContainerGap())
        );

        outputPanel.setBackground(new java.awt.Color(255, 255, 255));

        priceSlider.setMajorTickSpacing(10);
        priceSlider.setMinorTickSpacing(2);
        priceSlider.setPaintTicks(true);
        priceSlider.setToolTipText("");
        priceSlider.setValue(60);
        priceSlider.setOpaque(false);

        priceLable.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        priceLable.setText("Price");

        priceField.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N

        SaleLabel.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        SaleLabel.setText("Sale");

        saleSlider.setMajorTickSpacing(10);
        saleSlider.setMinorTickSpacing(2);
        saleSlider.setPaintTicks(true);
        saleSlider.setToolTipText("");
        saleSlider.setValue(30);
        saleSlider.setOpaque(false);

        saleField.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N

        MetaCritLAble.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        MetaCritLAble.setText("Metacritic Score");

        criticSlider.setMajorTickSpacing(10);
        criticSlider.setMinorTickSpacing(2);
        criticSlider.setPaintTicks(true);
        criticSlider.setToolTipText("");
        criticSlider.setValue(10);
        criticSlider.setOpaque(false);

        criticField.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N

        resultTextArea.setEditable(false);
        resultTextArea.setColumns(20);
        resultTextArea.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        resultTextArea.setLineWrap(true);
        resultTextArea.setRows(5);
        resultTextArea.setWrapStyleWord(true);
        resultTextArea.setBorder(null);
        jScrollPane2.setViewportView(resultTextArea);

        calculateBtn.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        calculateBtn.setText("Calculate");
        calculateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateBtnActionPerformed(evt);
            }
        });

        clearBtn.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        clearBtn.setLabel("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout outputPanelLayout = new javax.swing.GroupLayout(outputPanel);
        outputPanel.setLayout(outputPanelLayout);
        outputPanelLayout.setHorizontalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(priceSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(outputPanelLayout.createSequentialGroup()
                        .addComponent(priceLable, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(saleSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(outputPanelLayout.createSequentialGroup()
                        .addComponent(SaleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saleField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(criticSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(outputPanelLayout.createSequentialGroup()
                        .addComponent(MetaCritLAble, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(criticField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, outputPanelLayout.createSequentialGroup()
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(calculateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        outputPanelLayout.setVerticalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(priceLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priceField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SaleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saleField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saleSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MetaCritLAble, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(criticField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(criticSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calculateBtn)
                    .addComponent(clearBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(outputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * sets the current game panel to display the
     * current game
     * @param evt 
     */
    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        search();
    }//GEN-LAST:event_searchButtonMouseClicked

    private void search()
    {
        setGamePanel(currentGame);
    }
    
    /**
     * sets the gamePanel to display name, price, discount
     * and description, sets these values to "Game not found"
     * if the app can not be found
     * @param gamePanel 
     */
    private void setGamePanel(GamePanel gamePanel)
    {
        try
        {
            SteamApp app = steam.retrieve(gameInputField.getText());
            gamePanel.setGame(app);
        }
        catch(Throwable t)
        {
            gamePanel.setGameName("-Game not found-");
            gamePanel.setCost("--.--");
            gamePanel.setDiscount("---"); 
        } 
    }
    
    private void currentGamePanelComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_currentGamePanelComponentAdded
        
    }//GEN-LAST:event_currentGamePanelComponentAdded

    /**
     * 
     * @param evt 
     */
    private void calculateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateBtnActionPerformed
        //TODO add ranking system algorithm
        clearBtnActionPerformed(evt);
        gameList.stream().forEach((SteamApp app) -> {
            resultTextArea.append(app.getName() + "\n");
        });
    }//GEN-LAST:event_calculateBtnActionPerformed

    /**
     * clears the output display area
     * @param evt 
     */
    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        resultTextArea.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed
        if(!gameList.isEmpty() && appFromName(lm.get(addedGames.getSelectedIndex())).isPresent())
            currentGame.setGame(appFromName(lm.get(addedGames.getSelectedIndex())).get());
    }//GEN-LAST:event_viewBtnActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        if(!gameList.isEmpty() && !lm.isEmpty())
            removeGame(lm.get(addedGames.getSelectedIndex()));
    }//GEN-LAST:event_removeBtnActionPerformed

    private void clearGameListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearGameListBtnActionPerformed
        if(gameList.size() > 0)
            for(int i = gameList.size() - 1; i >= 0; --i)
            {
                removeGame(gameList.get(i));
            }
    }//GEN-LAST:event_clearGameListBtnActionPerformed

    private void gameInputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameInputFieldActionPerformed
        // TODO add your handling code here: 
        search();
    }//GEN-LAST:event_gameInputFieldActionPerformed
    
    private Optional<SteamApp> appFromName(String appName)
    {
        Optional<SteamApp> app = Optional.empty();
        for(SteamApp g : gameList)
        {
            if(g.getName().equals(appName))
                app = Optional.of(g);
        }
        
        if(!app.isPresent())
            return Optional.empty();
        return app;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainBox().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MetaCritLAble;
    private javax.swing.JLabel SaleLabel;
    private javax.swing.JList addedGames;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton calculateBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton clearGameListBtn;
    private javax.swing.JTextField criticField;
    private javax.swing.JSlider criticSlider;
    public GamePanel currentGame;
    private javax.swing.JPanel currentGamePanel;
    private javax.swing.JTextField gameInputField;
    private javax.swing.JLabel gameLabel;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel outputPanel;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel priceLable;
    private javax.swing.JSlider priceSlider;
    private javax.swing.JButton removeBtn;
    private javax.swing.JTextArea resultTextArea;
    private javax.swing.JTextField saleField;
    private javax.swing.JSlider saleSlider;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton viewBtn;
    // End of variables declaration//GEN-END:variables
    
    /**
     * is called when the current game panel button
     * is clicked and adds the game/app to the gameList
     * @param app 
     */
    public void currentGameAddBtnClicked(SteamApp app)
    {   
        if(!gameList.contains(app))
            gameList.add(app);
        if(!lm.contains(app.getName()))
            lm.addElement(app.getName());     
    }
    
    /**
     * Removes the provided app from the gameList
     * and the addedGames JList
     * @param app 
     */
    public void removeGame(SteamApp app)
    {
        lm.removeElement(app.getName());
        gameList.remove(app);
    }
    
    /**
     * Removes the provided app from the gameList
     * and the addedGames JList
     * @param appName
     */
    public void removeGame(String appName)
    {       
        Optional<SteamApp> app = appFromName(appName);
        if(app.isPresent())
            removeGame(app.get());
    }
}
