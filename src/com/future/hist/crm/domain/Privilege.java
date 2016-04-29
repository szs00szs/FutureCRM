package com.future.hist.crm.domain;

import java.util.HashSet;
import java.util.Set;

public class Privilege {

	private Long id;
	private String name;                //名称
	private String description;         //描述
	private String url;                
	private PrivilegeType type = PrivilegeType.menu;                
	private Privilege parent;           //父权限
	private String permission; //权限字符串
	private Set<Privilege> children = new HashSet<Privilege>(); //孩子权限
	private Set<Role> roles = new HashSet<Role>();
    private String parentIds; //父编号列表
    public static enum PrivilegeType {
        menu("菜单"), button("按钮");

        private final String info;
        private PrivilegeType(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }
    }
	public Privilege(String name, String url, Privilege parent) {
		super();
		this.name = name;
		this.url = url;
		this.parent = parent;
	}
	
	public Privilege() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public PrivilegeType getType() {
		return type;
	}

	public void setType(PrivilegeType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Privilege getParent() {
		return parent;
	}
	public void setParent(Privilege parent) {
		this.parent = parent;
	}
	public Set<Privilege> getChildren() {
		return children;
	}
	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Privilege [id=" + id + ", name=" + name + ", description=" + description + ", url=" + url + ", parent="
				+ parent + ", permission=" + permission + ", children=" + children + ", roles=" + roles + "]";
	}
	
}
