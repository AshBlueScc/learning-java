package E0搜索引擎框架.example1_solr;

import E0搜索引擎框架.utils.SolrUtil;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

/**
 * Created By ChengZhen on 2020/1/8.
 * Author: Ash
 * Date: 2020/1/8
 * Time: 18:03
 * Debug the codes and debug the world!
 */
public class Example2_TestSolr4j {

    public static void main(String[] args) throws SolrServerException, IOException {
        //高亮查询查询
        SolrUtil.queryHighlight("name:手机");

    }
}
