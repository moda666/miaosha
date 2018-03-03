package top.adxiang.miaosha.exception;

import top.adxiang.miaosha.result.CodeMsg;

/**
 * @author MaWenXiang
 * @date 2018/2/24
 */
public class GlobalException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg) {
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }

}
