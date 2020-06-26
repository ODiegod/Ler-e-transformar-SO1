package controller;

import java.io.IOException;

public interface IArquivosController {

	public void createFile (String path, String nome, String conteudo) throws IOException;
	public void readFile (String path, String nome) throws IOException;
	
}
