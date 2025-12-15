import java.awt.*;

class WinterWonderland extends Canvas
{
    private static final Color offwhite = new Color(240, 240, 240);
    private Snow[] snowFlakes;
    private int snowflakeIndex;
    private static int frameCounter = 0;
    private static boolean up = true;
    private static int colorIncr = 0;
    private static final int snowAddition = 5;

   public WinterWonderland()    //constructor method - sets up the class
   {
       setSize(800, 600);

       snowFlakes = new Snow[2500];
       for (int i = 0; i < 100; i++) {
           snowFlakes[i] = new Snow(800, 600);
       }
       snowflakeIndex = 100;
       Color lightBlue = new Color(173, 216, 230);
       setBackground(lightBlue);
       setVisible(true);
   }

   private void updateSnow(Graphics window) {
       for (int i = 0; i < snowflakeIndex; i++) {
           Snow snowFlake = snowFlakes[i];
           snowFlake.update(window);
       }
       if (snowflakeIndex / snowAddition < snowFlakes.length / snowAddition) {
           for (int i = 0; i < snowAddition; i++) {
               snowFlakes[snowflakeIndex] = new Snow(800, 600);
               snowflakeIndex++;
           }
       }
   }

   private void incrColorIncr() {
       if (up) colorIncr++;
       else colorIncr--;

       if (colorIncr < 0) {
           colorIncr++;
           up = true;
       } else if (colorIncr > 255) {
           colorIncr--;
           up = false;
       }
   }

   public void paint(Graphics window) {
       window.setPaintMode();

       theGround(window);
       //create several trees of varying sizes to the landscape
       tree1(window);
       tree2(window);
       tree3(window);
       //Decorate the largest tree with some ornaments and a tree topper
       //add a snowman or two
       snowman1(window);
       snowman2(window);
       //put some snow in the sky (you might try Math.random() to place some random
       //white dots in the sky)
       //add anything else that might enhance those Winter vibes
       updateSnow(window);

       window.setColor(Color.RED);
       window.drawString("Firstname Lastname, # Period", 35, 35 );
       incrColorIncr();
       frameCounter++;
   }

   public void theGround(Graphics window)
   {
       window.setColor(new Color(0, 120, 0));
       window.fillRect(0, 400, 800, 200);

       window.setColor(Color.WHITE);
       int incr = Utils.clamp(frameCounter / 20, 0, 50);

       if (frameCounter / 20 > 50) {
           incr -= Utils.clamp((frameCounter - 1000) / 20, 0, 50);
           int transparency = Utils.clamp((frameCounter - 1000) / 10, 0, 255);
           window.setColor(new Color(255, 255, 255, 255 - transparency));
       }
       window.fillRect(0, 400 - incr, 800, 200 + incr);
   }

   public void snowman1(Graphics window)
   {
	 //add more code here
       Color preColor = window.getColor();

       double heightPercent = 1 - Utils.clamp(((double) frameCounter - 1000) / 500, 0, 1);

       window.setColor(offwhite);
       window.fillOval(50, 455 - (int) (35 * heightPercent), 70, (int) (70 * heightPercent));
       window.fillOval(57, 455 - (int) (63 * heightPercent), 55, (int) (55 * heightPercent));
       window.fillOval(62, 455 - (int) (86 * heightPercent), 45, (int) (45 * heightPercent));
       window.setColor(Color.black);
       window.fillOval(65, 451 - (int) (71 * heightPercent), 10, 10);
       window.fillOval(85, 451 - (int) (71 * heightPercent), 10, 10);
       window.setColor(Color.ORANGE);
       Point tip = new Point(55, 456 - (int) (66 * heightPercent));
       Point baseTop = new Point(80, 451 - (int) (66 * heightPercent));
       Point baseBottom = new Point(80, 461 - (int) (66 * heightPercent));
       int[] xArray = {baseTop.x, baseBottom.x, tip.x};
       int[] yArray = {baseTop.y, baseBottom.y, tip.y};
       window.fillPolygon(xArray, yArray, xArray.length);

       window.setColor(preColor);
   }

   public void snowman2(Graphics window)
   {
	 //add more code here
       Color preColor = window.getColor();

       double heightPercent = 1 - Utils.clamp(((double) frameCounter - 1000) / 500, 0, 1);

       window.setColor(offwhite);
       window.fillOval(350, 455 - (int) (35 * heightPercent), 70, (int) (70 * heightPercent));
       window.fillOval(357, 455 - (int) (63 * heightPercent), 55, (int) (55 * heightPercent));
       window.fillOval(362, 455 - (int) (86 * heightPercent), 45, (int) (45 * heightPercent));
       window.setColor(Color.black);
       window.fillOval(370, 451 - (int) (71 * heightPercent), 10, 10);
       window.fillOval(390, 451 - (int) (71 * heightPercent), 10, 10);
       window.setColor(Color.ORANGE);
       Point tip = new Point(405, 456 - (int) (66 * heightPercent));
       Point baseTop = new Point(385, 451 - (int) (66 * heightPercent));
       Point baseBottom = new Point(385, 461 - (int) (66 * heightPercent));
       int[] xArray = {baseTop.x, baseBottom.x, tip.x};
       int[] yArray = {baseTop.y, baseBottom.y, tip.y};
       window.fillPolygon(xArray, yArray, xArray.length);

       window.setColor(preColor);
   }

   public void tree1( Graphics window )
   {
	  Color brown = new Color(88,43,9);
	  window.setColor(brown);
	  window.fillRect(200, 450, 50, 100);
	  Color darkGreen = new Color(10,48,4);
	  window.setColor(darkGreen);
      int[] x1 = {140,310,225};
      int[] y1 = {450,450,280};
      window.fillPolygon(x1, y1, 3);
      int[] x2 = {150,300,225};
      int[] y2 = {380,380,265};
      window.fillPolygon(x2, y2, 3);
      int[] x3 = {160,290,225};
      int[] y3 = {330,330,230};
      window.fillPolygon(x3, y3, 3);
      int[] x4 = {170,280,225};
      int[] y4 = {280,280,200};
      window.fillPolygon(x4, y4, 3);

      window.setColor(new Color(colorIncr, 255 - colorIncr / 2, 255 - colorIncr));
      window.fillOval(250, 400, 20, 20);

      window.setColor(new Color(255 - colorIncr / 3, 255 - colorIncr, colorIncr));
      window.fillOval(200, 350, 20, 20);

      window.setColor(new Color(255 - colorIncr, colorIncr, 255 - colorIncr / 4));
      window.fillOval(223, 290, 20, 20);

      window.setColor(Color.yellow);
      int[] x5 = {225, 230, 245, 235, 240, 225, 210, 215, 205, 220};
      int[] y5 = {180, 195, 195, 205, 220, 205, 220, 205, 195, 195};
      window.fillPolygon(x5, y5, 10);
   }
   public void tree2( Graphics window )
   {
	 //add more code here
       Color brown = new Color(88,43,9);
       window.setColor(brown);
       window.fillRect(200+275, 350, 50, 100);
       Color darkGreen = new Color(10,48,4);
       window.setColor(darkGreen);
       int[] x1 = {150+275,300+275,225+275};
       int[] y1 = {420,420,280};
       window.fillPolygon(x1, y1, 3);
       int[] x2 = {160+275,290+275,225+275};
       int[] y2 = {360,360,275};
       window.fillPolygon(x2, y2, 3);
       int[] x3 = {170+275,280+275,225+275};
       int[] y3 = {320,320,250};
       window.fillPolygon(x3, y3, 3);
   }
   public void tree3( Graphics window )
   {
	 //add more code here
       Color brown = new Color(88,43,9);
       window.setColor(brown);
       window.fillRect(200+450, 350, 50, 100);
       Color darkGreen = new Color(10,48,4);
       window.setColor(darkGreen);
       int[] x1 = {150+450,300+450,225+450};
       int[] y1 = {420,420,280};
       window.fillPolygon(x1, y1, 3);
       int[] x2 = {160+450,290+450,225+450};
       int[] y2 = {360,360,275};
       window.fillPolygon(x2, y2, 3);
       int[] x3 = {170+450,280+450,225+450};
       int[] y3 = {320,320,250};
       window.fillPolygon(x3, y3, 3);
   }
   public void snow(Graphics window) // method no longer used as it was replaced by the Snow class
   {
       Color preColor = window.getColor();
       window.setColor(Color.white);
        for (int i = 0; i < 100; i++) {
            int x = (int) (Math.random() * 801) - 1;
            int y = (int) (Math.random() * 601) - 1;
            window.fillOval(x, y, 5, 5);
        }
        //add more code here
	    //Try combining a for loop with Math.random() and window.fillOval()
        window.setColor(preColor);
   }
}