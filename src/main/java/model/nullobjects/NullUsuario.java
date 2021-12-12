package model.nullobjects;

import model.Usuario;

public class NullUsuario extends Usuario {
	
	public static Usuario build() {
		return new NullUsuario();
	}
	
	public NullUsuario() {
		super(0, "", 0.0, 0.0, null, null,false , false, "", "");
	}
	
	@Override
	public boolean esNull() {
		return true;
	}
}
