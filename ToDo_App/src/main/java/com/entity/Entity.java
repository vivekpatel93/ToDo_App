package com.entity;

public class Entity {
	private int Id;
	private String Name;
	private String ToDo;
	private String Status;
	
	
	public Entity() {
		super();
		
	}
	public int getId() {
		return Id;
	}
	public void setId(int Id) {
		this.Id = Id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getToDo() {
		return ToDo;
	}
	public void setToDo(String toDo) {
		ToDo = toDo;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "Entity [id=" + Id + ", Name=" + Name + ", ToDo=" + ToDo + ", Status=" + Status + "]";
	}
	
}
