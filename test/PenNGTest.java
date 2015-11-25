


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.testng.Assert;
import org.testng.annotations.*;



/**
 *
 * @author Anton
 */
public class PenNGTest {
    private static final int defaultInc = 6; // >5
    private static final String defaultColor = "GREY";
    private static final double defaultSizeLetter = 1.7;
    private final String defaultString = getDefaultString(defaultInc);
    
    public PenNGTest() {
        
    }
    
    
    /*Write method section
      SL - Size Letter
      Twice - call method twice. First time without assert
    */    
    @Test
    public void testPenWriteOfAllInc(){
        Pen simplePen = defaultPen(defaultInc);
        Assert.assertEquals(simplePen.write(defaultString),defaultString);
    }
    
    @Test
    public void testPenWriteMoreThanMaxInc(){      
        Pen simplePen = defaultPen(defaultInc);
        Assert.assertEquals(simplePen.write(defaultString+"AAAA"),defaultString);

    }
    
    @Test
    public void testPenWriteBelowMaxInc(){
        Pen simplePen = defaultPen(defaultInc);
        Assert.assertEquals(simplePen.write("aaa"),"aaa");
    }
    
    @Test
    public void testPentWriteTwice(){
        Pen simplePen = defaultPen(defaultInc*2);
        simplePen.write(defaultString);
        Assert.assertEquals(simplePen.write(defaultString),defaultString);
    }
    
    @Test
    public void testPenWriteBigSL(){
        Pen simplePen = defaultPen(defaultInc*2,2.0);
        Assert.assertEquals(simplePen.write(defaultString+defaultString),defaultString);
    }
    
    @Test
    public void testPenWriteBigSLTwice(){
        Pen simplePen = defaultPen(defaultInc*2,2.0);
        simplePen.write(defaultString);
        Assert.assertEquals(simplePen.write(defaultString),"");
    }
    
    @Test
    public void testPenWriteSmallSizeLetters(){
        Pen simplePen = defaultPen(defaultInc, 0.5);
        Assert.assertEquals(simplePen.write(defaultString+defaultString), defaultString+defaultString);
    }
    
    @Test
    public void testPenWriteSmallSLTwiceMoreThanMaxInc(){
        Pen simplePen = defaultPen(defaultInc, 0.5);
        simplePen.write(defaultString);
        Assert.assertEquals(simplePen.write(defaultString+"AAA"), defaultString);
    }
    
    @Test
    public void testPenWriteNegativeSL(){
        Pen simplePen = defaultPen(defaultInc,-3);
        Assert.assertEquals(simplePen.write(defaultString), "");
    }
    
    @Test
    public void testPenWriteNegativeInc(){
        Pen simplePen = defaultPen(-defaultInc);
        Assert.assertEquals(simplePen.write(defaultString), "");     
    }
    
    @Test
    public void testPenWriteNoInc(){
        Pen simplePen = defaultPen(0);
        Assert.assertEquals(simplePen.write(defaultString),"");
    }
    
    
    
    /*
        GetColor section
    */   
    @Test
    public void testPenGetColorSame(){
        Pen simplePen = defaultPen(defaultInc,defaultSizeLetter,defaultColor);
        Assert.assertEquals(simplePen.getColor(),defaultColor);
    }
    
    
    
    /*
        isWork section
    */
    @Test
    public void testPenIsWorkNegativeInc(){
        Pen simplePen = defaultPen(-defaultInc);
        Assert.assertFalse(simplePen.isWork());
    }
    
    @Test
    public void testPenIsWorkZeroInc(){
        Pen simplePen = defaultPen(0);
        Assert.assertFalse(simplePen.isWork());
    }
    
    
    
    /*
        doSomethingElse section
    */
    @Test
    public void testPenDoSomethingElse(){  
        // Is console output correct? 
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps); // Restream for a while to a new printStream;
        Pen defaultPen = new Pen(defaultInc,defaultSizeLetter,defaultColor);  
        defaultPen.doSomethingElse();
        System.out.flush();
        System.setOut(old); // stop restreaming System.out
        Assert.assertEquals(defaultColor, baos.toString().substring(0, 
                defaultColor.length())); 
        
        
    }
    
    
    
    public Pen defaultPen(int inputInc){
        Pen defaultPen = new Pen(inputInc);
        return defaultPen;
    }
    
    public Pen defaultPen(int inputInc, double inputSizeLetters){
        Pen defaultPen = new Pen(inputInc,inputSizeLetters);
        return defaultPen;
    }
        
    public Pen defaultPen(int inputInc, double inputSizeLetters, String inputColor){
        Pen defaultPen = new Pen(inputInc,inputSizeLetters, inputColor);
        return defaultPen;
    }
    
    //default string is a "aaaa..." string size of incContainerValue
    public String getDefaultString(int InputInc){
        String outputString;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<InputInc; i++){
            sb.append("a");
        }
        outputString = sb.toString();
        return outputString;
    }
    
    

    
    

}
