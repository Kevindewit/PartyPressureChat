package BusinessLogicLayer.Permission;

public class Text {

	private Permission sendMessage;
	private Permission attachFiles;

	public void operation() {
		// TODO - implement Text.operation
		throw new UnsupportedOperationException();
	}

	public Permission getSendMessage() {
		return this.sendMessage;
	}

	/**
	 * 
	 * @param sendMessage
	 */
	public void setSendMessage(Permission sendMessage) {
		this.sendMessage = sendMessage;
	}

	public Permission getAttachFiles() {
		return this.attachFiles;
	}

	/**
	 * 
	 * @param attachFiles
	 */
	public void setAttachFiles(Permission attachFiles) {
		this.attachFiles = attachFiles;
	}

}