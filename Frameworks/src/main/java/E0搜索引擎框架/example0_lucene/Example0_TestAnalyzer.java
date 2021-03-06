package E0搜索引擎框架.example0_lucene;
import org.apache.lucene.analysis.TokenStream;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
 
public class Example0_TestAnalyzer {
 
    public static void main(String[] args) throws IOException {
         
        IKAnalyzer analyzer = new IKAnalyzer();
        TokenStream ts= analyzer.tokenStream("name", "护眼带光源");
        ts.reset();
        while(ts.incrementToken()){
            System.out.println(ts.reflectAsString(false));
        }
    }
}