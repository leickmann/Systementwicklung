package com.example.observer.instance;

public interface ISubjekt {
	
	public void beobachterAnmelden(IBeobachter b);
	public void beobachterAbmelden(IBeobachter b);
	public void veraendern();
	public String gibZustand();
}
