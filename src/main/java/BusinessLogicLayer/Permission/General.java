package BusinessLogicLayer.Permission;

public abstract class General {

	private Permission manageChannel;
	private Permission managePermissions;
	private Permission readTextChannels;

	/**
	 * 
	 * @param manageChannel
	 * @param managePermissions
	 * @param readTextChannnels
	 */
	public General(Permission manageChannel, Permission managePermissions, Permission readTextChannnels) {
		// TODO - implement General.General
		throw new UnsupportedOperationException();
	}

	public Permission getManageChannel() {
		return this.manageChannel;
	}

	/**
	 * 
	 * @param manageChannel
	 */
	public void setManageChannel(Permission manageChannel) {
		this.manageChannel = manageChannel;
	}

	public Permission getManagePermissions() {
		return this.managePermissions;
	}

	/**
	 * 
	 * @param managePermissions
	 */
	public void setManagePermissions(Permission managePermissions) {
		this.managePermissions = managePermissions;
	}

	public Permission getReadTextChannels() {
		return this.readTextChannels;
	}

	/**
	 * 
	 * @param readTextChannels
	 */
	public void setReadTextChannels(Permission readTextChannels) {
		this.readTextChannels = readTextChannels;
	}

}