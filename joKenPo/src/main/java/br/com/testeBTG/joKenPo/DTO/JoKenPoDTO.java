package br.com.testeBTG.joKenPo.DTO;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JoKenPoDTO {

	@NotNull
	@JsonProperty(value = "resultado")
	private List<String> vencedores;

	@NotNull
	public JoKenPoDTO() {
	}

	public JoKenPoDTO(List<String> vencedores) {
		this.vencedores = vencedores;
	}

	public List<String> getVencedores() {
		return vencedores;
	}

	public void setVencedores(List<String> vencedores) {
		this.vencedores = vencedores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vencedores == null) ? 0 : vencedores.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JoKenPoDTO other = (JoKenPoDTO) obj;
		if (vencedores == null) {
			if (other.vencedores != null)
				return false;
		} else if (!vencedores.equals(other.vencedores))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JoKenPoDTO [vencedores=" + vencedores + "]";
	}

}
