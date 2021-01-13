package E0搜索引擎框架.example1_solr;

import E0搜索引擎框架.utils.ProductUtil;
import E0搜索引擎框架.utils.SolrUtil;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;
import java.util.List;

/**
 * Created By ChengZhen on 2020/1/8.
 * Author: Ash
 * Date: 2020/1/8
 * Time: 17:36
 * Debug the codes and debug the world!
 */
public class Example0_TestSolr4j {
    public static void main(String[] args) throws SolrServerException, IOException {
        List products = ProductUtil.file2list("框架/搜索引擎框架/140k_products.txt");
        SolrUtil.batchSaveOrUpdate(products);
    }
}
