O objetivo desse programa, é simular de forma simples um sistema de cadastro e login de contas, e salvando seus dados em um arquivo para um acesso futuro.
-------------------------------------------------------------

Ao iniciar o usuário terá as seguintes opções:
1- Criar nova conta
2- Fazer login
3- Sair

(Caso ainda não ouver nenhuma conta salva no arquivo, a ação de fazer login é cancelada)

#### CRIANDO UMA CONTA ####----------------------------------
Ao digitar o nome, o programa invalidará aquele com uso de carácteres que possam afetar o funcionamento de algumas operações (como o ";" por exemplo)

Ao digitar um e-mail, o programa invalidará aquele que não segue o padrao: nome@provedor.com

Ao digitar uma senha, o programa invalidará aquela que possua menos de 4 caracteres ou possua algum caractere especial
-------------------------------------------------------------

Ao logar em uma conta o usuário terá as seguintes opções:
1- Excluir conta
2- Sair da conta


Qualquer adição ou remoção de uma conta é salva dentro de um arquivo de texto(contas.txt) onde ficam as informações de cada conta(nome, e-mail e senha).

O formato dos dados salvos de uma conta no arquivo de texto é: <nome>;<e-mail>;<senha>
Onde cada linha representa uma conta diferente.
