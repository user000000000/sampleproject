package EncodingFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * エンコーディングフィルタクラス
 * @author answer
 */
public class EncodingFilter implements Filter {

    private String encoding = null;

    /**
     * Web コンテナは、Filter をサービス状態にするために init メソッドを呼び出します。
     * Servlet コンテナは、Filter をインスタンス化したあと、一度だけ init メソッドを呼び出します。
     * Filter がフィルタリングの仕事を依頼される前に、init メソッドは正常に完了してなければいけません。
     *
     * init メソッドが以下のような状況になると、Web コンテナは Filter をサービス状態にできません。
     * 1. ServletException をスローした
     * 2. Web コネクタで定義した時間内に戻らない
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
    }

    /**
     * Filter クラスの doFilter メソッドはコンテナにより呼び出され、最後のチェーンにおけるリソースへのクライアントリクエストのために、
     * 毎回リクエストレスポンスのペアが、チェーンを通して渡されます。
     * このメソッドに渡される FilterChain を利用して、Filter がリクエストやレスポンスをチェーン内の次のエンティティ (Filter) にリクエストとレスポンスを渡す事ができます。
     *
     * このメソッドの典型的な実装は以下のようなパターンとなるでしょう。
     * 1. リクエストの検査
     * 2. オプションとして、入力フィルタリング用にコンテンツもしくはヘッダをフィルタリングするためにカスタム実装によるリクエストオブジェクトのラップ
     * 3. オプションとして、出力フィルタリング用にコンテンツもしくはヘッダをフィルタリングするためにカスタム実装によるレスポンスオブジェクトラップ
     * 4. 以下の a)、b) の どちらか
     * a) FileterChain オブジェクト(chain.doFilter()) を利用してチェーンの次のエンティティを呼び出す
     * b) リクエスト処理を止めるために、リクエストレスポンスのペアをフィルタチェーンの次のエンティティに渡さない
     * 5. フィルタチェーンの次のエンティティの呼び出した後、直接レスポンスのヘッダをセット
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException,
            ServletException {
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }

    /**
     * サービス状態を終えた事を Filter に伝えるために Web コンテナが呼び出します。
     * Filter の doFilter メソッドが終了したか、タイムアウトに達した全てのスレッドにおいて、このメソッドを一度だけ呼び出されます。
     * Web コンテナがこのメソッドを呼び出した後は、Filter のこのインスタンスにおいて二度と doFilter メソッドを呼び出す事はありません。
     *
     * このメソッドは、フィルタに保持されている (例えば、メモリ、ファイルハンドル、スレッド) 様々なリソースを開放する機会を与え、
     * あらゆる永続性の状態が、メモリ上における Filter の現在の状態と同期しているように注意してください。
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
        encoding = null;
    }

}