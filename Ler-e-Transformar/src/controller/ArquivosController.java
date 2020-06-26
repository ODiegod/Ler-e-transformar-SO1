package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class ArquivosController implements IArquivosController {

	@Override
	public void createFile(String path, String nome, String linha) throws IOException {
		File dir = new File(path);
		File arq = new File(path, nome+ ".csv");
		if (dir.exists() & dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			FileWriter fileWriter = new FileWriter(arq,existe);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(linha);
			print.flush();
			print.close();
			fileWriter.close();
		}else {
			throw new IOException("Diretório Inválido");
		}
	}

	@Override
	public void readFile(String path, String nome) throws IOException {
		File arq = new File(path,nome+".txt");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			StringBuffer sbuffer = new StringBuffer();
			String linha = buffer.readLine();
			while (linha != null) {
				linha = linha.replaceAll(" ", ";");
				sbuffer.append(linha+ "\r\n");
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			createFile(path, nome, sbuffer.toString());

		}else {
			throw new IOException("Arquivo Inválido");
		}		
	}

}
