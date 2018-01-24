package cn.senninha.equipment.container;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.senninha.equipment.container.client.Client;

/**
 * 在线桩容器
 * @author senninha on 2018年1月13日
 *
 */
public class ClientContainer {
	private static ClientContainer instance;
	private Map<String, Client> map;

	private ClientContainer() {
		map = new ConcurrentHashMap<>();
	}

	public static ClientContainer getInstance(){
		if(instance == null){
			synchronized (ClientContainer.class) {
				if(instance == null){
					instance = new ClientContainer();
				}
			}
		}
		return instance;
	}
	
	/**
	 * 加入在线容器，如果存在重名的，默认干掉先到的
	 * @param equipmentId
	 * @param client
	 * @return		返回重名的
	 */
	public Client add(String equipmentId, Client client){
		if(equipmentId != null && client != null){
			return map.put(equipmentId, client);
		}
		throw new IllegalArgumentException("client or equipmentId can not be null");
	}
	
	/**
	 * 删除在线桩
	 * @param equipmentId	不能为null
	 * @return 返回移除的连接
	 */
	public Client remove(String equipmentId){
		if(equipmentId == null){
			throw new IllegalArgumentException("equipmentId can not be null");
		}
		return map.remove(equipmentId);
	}

    /**
     * 获取在线桩容器，若为null，不在线
     * @param equipmentId
     * @return
     */
	public Client get(String equipmentId){
        if(equipmentId == null){
            throw new IllegalArgumentException("equipmentId can not be null");
        }
	    return map.get(equipmentId);
    }

    /**
     * 返回所有在线桩
     * @return
     */
    public Collection<Client> getALL(){
	    return this.map.values();
    }
	
	/**
	 * 加锁方法，谨慎调用
	 * @return
	 */
	public int onlineNum(){
		synchronized (map) {
			return map.size();
		}
	}
}
