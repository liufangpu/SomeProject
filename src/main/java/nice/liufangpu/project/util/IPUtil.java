package nice.liufangpu.project.util;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * Title: 字符串操作工具类
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author
 * @version
 */
public class IPUtil {

	private static Logger logger = Logger.getLogger(IPUtil.class);

	/**
	 * 获取用户的真实IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getUserIpAddr(HttpServletRequest request) {
		String unknown = "unknown";
		String ip = request.getHeader("X-Real-IP");
		if (StringUtils.isBlank(ip) || unknown.equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-forwarded-for");
		}

		if (StringUtils.isBlank(ip) || unknown.equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}

		if (StringUtils.isBlank(ip) || unknown.equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}

		if (StringUtils.isBlank(ip) || unknown.equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		if (null != ip && ip.length() != 0) {
			String tmpIps[] = ip.split(",");
			for (String tmpIp : tmpIps) {
				if (null == tmpIp) {
					continue;
				}
				tmpIp = tmpIp.trim();
				if (tmpIp.length() != 0 && !unknown.equalsIgnoreCase(tmpIp)
						&& tmpIp.indexOf("127.0.0.1") == -1
						&& !tmpIp.startsWith("192.168.")) {
					return tmpIp;
				}
			}
		}
		return request.getRemoteAddr();
	}

	/**
	 * 获取用户的代理IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getSubIpAddr(HttpServletRequest request) {
		String unknown = "unknown";
		String ip = request.getHeader("x-forwarded-for");
		if (ip != null && ip.length() > 0 && !unknown.equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("Proxy-Client-IP");
		if (ip != null && ip.length() > 0 && !unknown.equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("WL-Proxy-Client-IP");
		if (ip != null && ip.length() > 0 && !unknown.equalsIgnoreCase(ip)) {
			return ip;
		}
		return request.getRemoteAddr();
	}
}
