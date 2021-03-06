package cn.edu.gzmu.model.exception;

/**
 * 资源未找到异常
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-21 10:43:57
 */
public class ResourceExistException extends RuntimeException {

    public ResourceExistException(){
        super("资源已存在！");
    }

    public ResourceExistException(String message) {
        super(message);
    }

    public ResourceExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
