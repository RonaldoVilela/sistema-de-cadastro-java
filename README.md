O objetivo desse programa, é simular de forma simples um sistema de cadastro e login de contas, e salvando seus dados em um arquivo para um acesso futuro.
-------------------------------------------------------------

Ao iniciar, o usuário terá as seguintes opções:
<p>1- Criar nova conta</p>
<p>2- Fazer login</p>
<p>3- Sair</p>
<p></p>
(Caso ainda não ouver nenhuma conta salva no arquivo, a ação de fazer login é cancelada)

-------------------------------------------------------------
#### CRIANDO UMA CONTA ####
Ao digitar o nome, o programa invalidará aquele com uso de carácteres que possam afetar o funcionamento de algumas operações (como o ";" por exemplo)

Ao digitar um e-mail, o programa invalidará aquele que não segue o padrao: nome@provedor.com

Ao digitar uma senha, o programa invalidará aquela que possua menos de 4 caracteres ou possua algum caractere especial

-------------------------------------------------------------

Ao logar em uma conta, o usuário terá as seguintes opções:
<p>1- Excluir conta</p>
<p>2- Sair da conta</p>


Qualquer adição ou remoção de uma conta é salva dentro de um arquivo de texto(contas.txt) onde ficam as informações de cada conta(nome, e-mail e senha).

O formato dos dados salvos de uma conta no arquivo de texto é: nome;e-mail;senha
<p>Onde cada linha representa uma conta diferente.</p>
