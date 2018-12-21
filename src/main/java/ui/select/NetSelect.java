package ui.select;

import javax.swing.JComboBox;

import listener.MessageReceivedListener;
import model.DataManager;
import net.INet;
import net.NetTCPClient;
import net.NetTCPServer;
import net.NetUDPServer;

@SuppressWarnings("serial")
public class NetSelect extends JComboBox<INet> {
	public NetSelect(DataManager data) {
		//数据监听器，在收到数据之后，添加到数据中心
		MessageReceivedListener messageReceived = (bytes) -> {
			data.addMessage(bytes);;
		};
		// 网络类型集合
		addItem(new NetTCPServer(data, messageReceived));
		addItem(new NetTCPClient(data, messageReceived));
		addItem(new NetUDPServer(data, messageReceived));
	}
	
	@Override
	public INet getSelectedItem() {
		return (INet) super.getSelectedItem();
	}
}
