package br.com.ifpe.oxefood.api.cliente;

import java.time.LocalDate;
import java.util.Arrays;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

   
    @NotBlank(message = "O e-mail é de preenchimento obrigatório")
    @Email
    private String email;

    @NotBlank(message = "A senha é de preenchimento obrigatório")
    
    private String password;
    private String nome;
   
   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataNascimento;

   private String cpf;

   private String foneCelular;

   private String foneFixo;

   public Cliente build() {

       return Cliente.builder()
               .nome(nome)
               .cpf(cpf)
               .usuario(buildUsuario())
		         .nome(nome)
               .foneCelular(foneCelular)
               .foneFixo(foneFixo)
               .dataNascimento(dataNascimento)
               .build();
   }

    public Usuario buildUsuario() {
	
	return Usuario.builder()
		.username(email)
		.password(password)
		.roles(Arrays.asList(Usuario.ROLE_CLIENTE))
		.build();
    }

}
