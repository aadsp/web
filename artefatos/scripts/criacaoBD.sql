USE [AADSP]
GO
/****** Object:  Schema [ACESSO]    Script Date: 07/04/2016 01:59:47 ******/
CREATE SCHEMA [ACESSO] AUTHORIZATION [dbo]
GO
/****** Object:  Schema [COLABORADOR]    Script Date: 07/04/2016 01:59:47 ******/
CREATE SCHEMA [COLABORADOR] AUTHORIZATION [dbo]
GO
/****** Object:  Schema [PROJETO]    Script Date: 07/04/2016 01:59:47 ******/
CREATE SCHEMA [PROJETO] AUTHORIZATION [dbo]
GO
/****** Object:  Schema [TAP]    Script Date: 07/04/2016 01:59:47 ******/
CREATE SCHEMA [TAP] AUTHORIZATION [dbo]
GO
/****** Object:  Schema [REQUISITOS]    Script Date: 07/04/2016 01:59:47 ******/
CREATE SCHEMA [REQUISITOS] AUTHORIZATION [dbo]
GO
/****** Object:  Table [TAP].[STAKEHOLDER]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [TAP].[STAKEHOLDER](
	[ID_stakeholder] [int] IDENTITY(1,1) NOT NULL,
	[nome] [nvarchar](80) NOT NULL,
	[rg] [nvarchar](30) NOT NULL,
	[cpf] [nvarchar](30) NOT NULL,
	[email] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_TAP_AADSP_STAKEHOLDER] PRIMARY KEY CLUSTERED 
(
	[ID_stakeholder] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [TAP].[STAKEHOLDER] ON
INSERT [TAP].[STAKEHOLDER] ([ID_stakeholder], [nome], [rg], [cpf], [email]) VALUES (5, N'Felipe Coelho', N'12345678', N'123456789', N'felipe.pereira.coelho@gmail.com')
INSERT [TAP].[STAKEHOLDER] ([ID_stakeholder], [nome], [rg], [cpf], [email]) VALUES (6, N'Danilo ', N'123456789', N'1234567890', N'danilo@teste.com')
INSERT [TAP].[STAKEHOLDER] ([ID_stakeholder], [nome], [rg], [cpf], [email]) VALUES (7, N'Lucas', N'123456789', N'123456789', N'lucas@teste.com')
SET IDENTITY_INSERT [TAP].[STAKEHOLDER] OFF
/****** Object:  Table [TAP].[RESPONSAVEL]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [TAP].[RESPONSAVEL](
	[ID_responsavel] [int] IDENTITY(1,1) NOT NULL,
	[ID_usuario] [int] NOT NULL,
	[ID_tap] [int] NOT NULL,
 CONSTRAINT [PK_TAP_AADSP_RESPONSAVEL] PRIMARY KEY CLUSTERED 
(
	[ID_responsavel] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [TAP].[RESPONSAVEL] ON
INSERT [TAP].[RESPONSAVEL] ([ID_responsavel], [ID_usuario], [ID_tap]) VALUES (11, 1, 7)
INSERT [TAP].[RESPONSAVEL] ([ID_responsavel], [ID_usuario], [ID_tap]) VALUES (12, 13, 17)
SET IDENTITY_INSERT [TAP].[RESPONSAVEL] OFF
/****** Object:  Table [ACESSO].[USUARIO]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [ACESSO].[USUARIO](
	[ID_usuario] [int] IDENTITY(1,1) NOT NULL,
	[nome] [nvarchar](70) NOT NULL,
	[dataNascimento] [datetime] NOT NULL,
	[rg] [nvarchar](30) NOT NULL,
	[cpf] [nvarchar](30) NOT NULL,
	[email] [nvarchar](100) NOT NULL,
	[login] [nvarchar](30) NOT NULL,
	[senha] [nvarchar](257) NOT NULL,
	[ID_funcao] [int] NOT NULL,
	[imagem] [nvarchar](100) NULL,
 CONSTRAINT [PK_USUARIO] PRIMARY KEY CLUSTERED 
(
	[ID_usuario] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [UC_ACESSO_AADSP_USUARIO_EMAIL] UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [ACESSO].[USUARIO] ON
INSERT [ACESSO].[USUARIO] ([ID_usuario], [nome], [dataNascimento], [rg], [cpf], [email], [login], [senha], [ID_funcao], [imagem]) VALUES (1, N'MASTER', CAST(0x0000A5EA00000000 AS DateTime), N'000000001', N'0000000043', N'felipe.pereira.coelho@gmail.com', N'adm', N'5994471ABB01112AFCC18159F6CC74B4F511B99806DA59B3CAF5A9C173CACFC5', 1, N'1467601268506')
INSERT [ACESSO].[USUARIO] ([ID_usuario], [nome], [dataNascimento], [rg], [cpf], [email], [login], [senha], [ID_funcao], [imagem]) VALUES (11, N'Teste', CAST(0x0000A5F900000000 AS DateTime), N'000000001', N'000000002', N'aadsp@gmail.com', N'fcoelho', N'AD55550FF40B8E33A776CF349B1524C9B1BCA582BE0C52A55029D771D39049F3', 10, NULL)
INSERT [ACESSO].[USUARIO] ([ID_usuario], [nome], [dataNascimento], [rg], [cpf], [email], [login], [senha], [ID_funcao], [imagem]) VALUES (13, N'Camila Chagas', CAST(0x0000833200000000 AS DateTime), N'789778978', N'8998789898', N'camilacomunica@gmail.com', N'camila', N'5994471ABB01112AFCC18159F6CC74B4F511B99806DA59B3CAF5A9C173CACFC5', 10, NULL)
INSERT [ACESSO].[USUARIO] ([ID_usuario], [nome], [dataNascimento], [rg], [cpf], [email], [login], [senha], [ID_funcao], [imagem]) VALUES (14, N'Bolsista', CAST(0x0000A63900000000 AS DateTime), N'0000000000', N'0000000000', N'aadsp.labrasoft@gmail.com', N'bolsista', N'5994471ABB01112AFCC18159F6CC74B4F511B99806DA59B3CAF5A9C173CACFC5', 37, NULL)
SET IDENTITY_INSERT [ACESSO].[USUARIO] OFF
/****** Object:  Table [PROJETO].[TELAS]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[TELAS](
	[ID_projetoTelas] [int] IDENTITY(1,1) NOT NULL,
	[imagem] [nvarchar](100) NOT NULL,
	[descricao] [nvarchar](800) NOT NULL,
	[ID_projeto] [int] NOT NULL,
	[ID_requisito] [int] NULL,
 CONSTRAINT [PK_PROJETO_AADSP_PROJETO_TELAS] PRIMARY KEY CLUSTERED 
(
	[ID_projetoTelas] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [PROJETO].[TELAS] ON
INSERT [PROJETO].[TELAS] ([ID_projetoTelas], [imagem], [descricao], [ID_projeto], [ID_requisito]) VALUES (5, N'1465326928057', N'teste de cadastro de mockup', 6, NULL)
SET IDENTITY_INSERT [PROJETO].[TELAS] OFF
/****** Object:  Table [TAP].[TAP]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [TAP].[TAP](
	[ID_tap] [int] IDENTITY(1,1) NOT NULL,
	[nome] [nvarchar](250) NOT NULL,
	[justificativa] [nvarchar](1500) NOT NULL,
	[objetivo] [nvarchar](500) NOT NULL,
	[alinhamentoEstrategico] [nvarchar](500) NULL,
	[custo] [decimal](18, 2) NULL,
	[dataInicio] [datetime] NOT NULL,
	[dataFim] [datetime] NOT NULL,
	[dataHomologacao] [datetime] NULL,
	[dataCriacao] [datetime] NOT NULL,
	[premissas] [nvarchar](250) NULL,
	[restricoes] [nvarchar](250) NULL,
	[riscosIniciais] [nvarchar](300) NULL,
 CONSTRAINT [PK_TAP_AADSP_TAP] PRIMARY KEY CLUSTERED 
(
	[ID_tap] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [TAP].[TAP] ON
INSERT [TAP].[TAP] ([ID_tap], [nome], [justificativa], [objetivo], [alinhamentoEstrategico], [custo], [dataInicio], [dataFim], [dataHomologacao], [dataCriacao], [premissas], [restricoes], [riscosIniciais]) VALUES (7, N'teste projeto', N'teste justificativa', N'teste objetivo', N'', CAST(5000.00 AS Decimal(18, 2)), CAST(0x0000A5F700000000 AS DateTime), CAST(0x0000A5F800000000 AS DateTime), NULL, CAST(0x0000A60800000000 AS DateTime), N'', N'', N'')
INSERT [TAP].[TAP] ([ID_tap], [nome], [justificativa], [objetivo], [alinhamentoEstrategico], [custo], [dataInicio], [dataFim], [dataHomologacao], [dataCriacao], [premissas], [restricoes], [riscosIniciais]) VALUES (17, N'Normatização de dados CPJ', N'Dados inconsistentes apresentados em relatórios', N'Correção de dados para relatórios', N'', CAST(50000.00 AS Decimal(18, 2)), CAST(0x0000A60D00000000 AS DateTime), CAST(0x0000A60F00000000 AS DateTime), NULL, CAST(0x0000A60D00000000 AS DateTime), N'Todos do CPJ será normatizado a fim de gerar relatórios consistentes ', N'Não acessar os dados financeiros do banco de dados', N'Possíveis perdas de informações')
INSERT [TAP].[TAP] ([ID_tap], [nome], [justificativa], [objetivo], [alinhamentoEstrategico], [custo], [dataInicio], [dataFim], [dataHomologacao], [dataCriacao], [premissas], [restricoes], [riscosIniciais]) VALUES (18, N'Desenvolvimento de software para prestação de contas  - UFBA', N'Um dos principais deveres do colaborador é de desempenhar, a tempo as atribuições do cargo ou função que seja titular. Desse modo necessita exercer suas atribuições com rapidez, perfeição e rendimento, pondo fim ou procurando prioritariamente resolver situações procrastinatórias, principalmente diante de filas ou de qualquer outra espécie de atraso na prestação dos serviços pelo setor que exerça suas atribuições, com fim de evitar dano moral ao usuário. Além disto, é de sua responsabilidade jamais retardar qualquer prestação de contas, condição essencial da gestão dos bens, direitos e serviços da coletividade a seu cargo. Dentro dos princípios constitucionais desta empresa temos o princípio da eficiência. Este que diz respeito à necessidade de a administração buscar alcançar os melhores resultados possíveis ao interesse do cliente. Assim no contexto da sociedade atual, a utilização de sistemas para gerenciamento e tratamento de dados a fim de garantir agilidade e integridade das informações que são oriundas das atividades exercidas dentro desta empresa voltada à Pesquisa e à Extensão.', N'O objetivo desse projeto é de desenvolver um software que auxilie na prestação de contas dos colaboradores da FAPEX. Promovendo agilidade e confiabilidade nas informações fornecidas dentro das competências desta atividade.', N'', CAST(120000.00 AS Decimal(18, 2)), CAST(0x0000A61C00000000 AS DateTime), CAST(0x0000A63F00000000 AS DateTime), NULL, CAST(0x0000A63300000000 AS DateTime), N'', N'', N'')
INSERT [TAP].[TAP] ([ID_tap], [nome], [justificativa], [objetivo], [alinhamentoEstrategico], [custo], [dataInicio], [dataFim], [dataHomologacao], [dataCriacao], [premissas], [restricoes], [riscosIniciais]) VALUES (19, N'Realização de Estimativas utilizando Análise de Pontos de Função', N'O processo de contagem dos pontos de função é muito importante para mensuração e estimativas de tamanho de um software.', N'Aplicação de um projeto de Testes ao artigo de ponto de função Realização de Estimativas utilizando Análise de Pontos de Função - MONALESSA PERINI BARCELLOS', N'', CAST(0.00 AS Decimal(18, 2)), CAST(0x0000A63900000000 AS DateTime), CAST(0x0000A63900000000 AS DateTime), NULL, CAST(0x0000A63900000000 AS DateTime), N'', N'', N'')
SET IDENTITY_INSERT [TAP].[TAP] OFF
/****** Object:  Table [PROJETO].[PONTO_TIPO_TRANSACAO_TIPO]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[PONTO_TIPO_TRANSACAO_TIPO](
	[ID_tipoTransacaoTipo] [int] IDENTITY(1,1) NOT NULL,
	[sigla] [nvarchar](10) NOT NULL,
	[descricao] [nvarchar](60) NOT NULL,
 CONSTRAINT [PK_PONTO_TIPO_TRANSACAO_TIPO] PRIMARY KEY CLUSTERED 
(
	[ID_tipoTransacaoTipo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [PROJETO].[PONTO_TIPO_TRANSACAO_TIPO] ON
INSERT [PROJETO].[PONTO_TIPO_TRANSACAO_TIPO] ([ID_tipoTransacaoTipo], [sigla], [descricao]) VALUES (1, N'EE', N'Entradas Externas')
INSERT [PROJETO].[PONTO_TIPO_TRANSACAO_TIPO] ([ID_tipoTransacaoTipo], [sigla], [descricao]) VALUES (2, N'SE', N'Saídas Externas')
INSERT [PROJETO].[PONTO_TIPO_TRANSACAO_TIPO] ([ID_tipoTransacaoTipo], [sigla], [descricao]) VALUES (3, N'ECE', N'Entrada das Consulta Externas')
INSERT [PROJETO].[PONTO_TIPO_TRANSACAO_TIPO] ([ID_tipoTransacaoTipo], [sigla], [descricao]) VALUES (5, N'SCE', N'Saídas das Consultas Externas')
SET IDENTITY_INSERT [PROJETO].[PONTO_TIPO_TRANSACAO_TIPO] OFF
/****** Object:  Table [PROJETO].[PONTO_TIPO_DADOS_TIPO]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[PONTO_TIPO_DADOS_TIPO](
	[ID_pontoTipoDados] [int] IDENTITY(1,1) NOT NULL,
	[sigla] [nvarchar](10) NOT NULL,
	[descricao] [nvarchar](60) NOT NULL,
 CONSTRAINT [PK_PONTO_TIPO_DADOS_TIPO] PRIMARY KEY CLUSTERED 
(
	[ID_pontoTipoDados] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [PROJETO].[PONTO_TIPO_DADOS_TIPO] ON
INSERT [PROJETO].[PONTO_TIPO_DADOS_TIPO] ([ID_pontoTipoDados], [sigla], [descricao]) VALUES (1, N'ALI', N'Arquivo Lógico Interno')
INSERT [PROJETO].[PONTO_TIPO_DADOS_TIPO] ([ID_pontoTipoDados], [sigla], [descricao]) VALUES (2, N'AIE', N'Arquivo de Interface Externa')
SET IDENTITY_INSERT [PROJETO].[PONTO_TIPO_DADOS_TIPO] OFF
/****** Object:  Table [PROJETO].[PONTO_GRAU_INFLUENCIA]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[PONTO_GRAU_INFLUENCIA](
	[ID_grauInfluencia] [int] IDENTITY(1,1) NOT NULL,
	[grau] [int] NOT NULL,
	[descricao] [nvarchar](30) NOT NULL,
 CONSTRAINT [PK_PONTO_GRAU_INFLUENCIA] PRIMARY KEY CLUSTERED 
(
	[ID_grauInfluencia] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [PROJETO].[PONTO_GRAU_INFLUENCIA] ON
INSERT [PROJETO].[PONTO_GRAU_INFLUENCIA] ([ID_grauInfluencia], [grau], [descricao]) VALUES (1, 1, N'Influência mínima')
INSERT [PROJETO].[PONTO_GRAU_INFLUENCIA] ([ID_grauInfluencia], [grau], [descricao]) VALUES (2, 2, N'Influência moderada')
INSERT [PROJETO].[PONTO_GRAU_INFLUENCIA] ([ID_grauInfluencia], [grau], [descricao]) VALUES (3, 3, N'Influência média')
INSERT [PROJETO].[PONTO_GRAU_INFLUENCIA] ([ID_grauInfluencia], [grau], [descricao]) VALUES (4, 4, N'Influência significante')
INSERT [PROJETO].[PONTO_GRAU_INFLUENCIA] ([ID_grauInfluencia], [grau], [descricao]) VALUES (5, 5, N'Influência forte')
INSERT [PROJETO].[PONTO_GRAU_INFLUENCIA] ([ID_grauInfluencia], [grau], [descricao]) VALUES (6, 0, N'Nenhuma influência')
SET IDENTITY_INSERT [PROJETO].[PONTO_GRAU_INFLUENCIA] OFF
/****** Object:  Table [PROJETO].[PONTO_COMPLEXIDADE_NIVEL]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[PONTO_COMPLEXIDADE_NIVEL](
	[ID_complexidadeNivel] [int] IDENTITY(1,1) NOT NULL,
	[descricao] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_PROJETO_AADSP_PROJETO_PONTO_COMPLEXIDADE_NIVEL] PRIMARY KEY CLUSTERED 
(
	[ID_complexidadeNivel] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [PROJETO].[PONTO_COMPLEXIDADE_NIVEL] ON
INSERT [PROJETO].[PONTO_COMPLEXIDADE_NIVEL] ([ID_complexidadeNivel], [descricao]) VALUES (1, N'BAIXA')
INSERT [PROJETO].[PONTO_COMPLEXIDADE_NIVEL] ([ID_complexidadeNivel], [descricao]) VALUES (2, N'MÉDIA')
INSERT [PROJETO].[PONTO_COMPLEXIDADE_NIVEL] ([ID_complexidadeNivel], [descricao]) VALUES (3, N'ALTA')
SET IDENTITY_INSERT [PROJETO].[PONTO_COMPLEXIDADE_NIVEL] OFF
/****** Object:  Table [ACESSO].[PAGINA]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [ACESSO].[PAGINA](
	[ID_pagina] [int] IDENTITY(1,1) NOT NULL,
	[nome] [nvarchar](60) NOT NULL,
 CONSTRAINT [PK_PAGINA] PRIMARY KEY CLUSTERED 
(
	[ID_pagina] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [UQPaginaNome] UNIQUE NONCLUSTERED 
(
	[nome] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [ACESSO].[PAGINA] ON
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (8, N'AcessoCadastrar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (7, N'AcessoConsultar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (14, N'AcessoEditar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (50, N'AlterarImagem')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (21, N'AlterarSenha')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (47, N'ATACadastrar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (46, N'ATAConsultar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (49, N'ATAEditar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (57, N'CEPSConsultar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (58, N'CEPSEditar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (41, N'ColaboradorCadastrar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (28, N'ColaboradorConsultar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (42, N'ColaboradorEditar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (61, N'DEEConsultar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (62, N'DEEEditar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (52, N'DocumentoRequisitosCadastrar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (51, N'DocumentoRequisitosConsultar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (53, N'DocumentoRequisitosEditar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (55, N'EAPCadastrar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (54, N'EAPConsultar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (56, N'EAPEditar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (24, N'EmpresaCadastrar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (23, N'EmpresaConsultar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (22, N'EmpresaEditar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (6, N'FuncaoCadastrar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (5, N'FuncaoConsultar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (13, N'FuncaoEditar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (1, N'Index')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (4, N'PaginaCadastrar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (3, N'PaginaConsultar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (16, N'PaginaEditar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (9, N'PessoalCadastrar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (2, N'PessoalConsultar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (20, N'PessoalEditar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (44, N'ProjetoCadastrar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (43, N'ProjetoConsultar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (48, N'ProjetoEditar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (59, N'REConsultar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (60, N'REEditar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (45, N'ReunioesConsultar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (25, N'StakeholderCadastrar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (26, N'StakeholderConsultar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (27, N'StakeholderEditar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (12, N'TAPCadastrar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (11, N'TAPConsultar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (15, N'TAPEditar')
INSERT [ACESSO].[PAGINA] ([ID_pagina], [nome]) VALUES (10, N'UsuariosVisualizar')
SET IDENTITY_INSERT [ACESSO].[PAGINA] OFF
/****** Object:  Table [ACESSO].[FUNCAO]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [ACESSO].[FUNCAO](
	[ID_funcao] [int] IDENTITY(1,1) NOT NULL,
	[sigla] [nvarchar](10) NOT NULL,
	[descricao] [nchar](60) NOT NULL,
 CONSTRAINT [PK_FUNCAO] PRIMARY KEY CLUSTERED 
(
	[ID_funcao] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [UQFuncao] UNIQUE NONCLUSTERED 
(
	[sigla] ASC,
	[descricao] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [ACESSO].[FUNCAO] ON
INSERT [ACESSO].[FUNCAO] ([ID_funcao], [sigla], [descricao]) VALUES (28, N'A. P&D', N'ANALISTA DE P&D                                             ')
INSERT [ACESSO].[FUNCAO] ([ID_funcao], [sigla], [descricao]) VALUES (9, N'A.D.', N'ADMINISTRADOR DE DADOS                                      ')
INSERT [ACESSO].[FUNCAO] ([ID_funcao], [sigla], [descricao]) VALUES (8, N'A.D.', N'ANALISTA DE DADOS                                           ')
INSERT [ACESSO].[FUNCAO] ([ID_funcao], [sigla], [descricao]) VALUES (12, N'A.I.', N'ANALISTA DE INFRA                                           ')
INSERT [ACESSO].[FUNCAO] ([ID_funcao], [sigla], [descricao]) VALUES (5, N'A.P.D.S.', N'ANALISTA DE PROCESSO                                        ')
INSERT [ACESSO].[FUNCAO] ([ID_funcao], [sigla], [descricao]) VALUES (11, N'A.S.', N'ANALISTA DE SISTEMAS                                        ')
INSERT [ACESSO].[FUNCAO] ([ID_funcao], [sigla], [descricao]) VALUES (37, N'B', N'BOLSISTA                                                    ')
INSERT [ACESSO].[FUNCAO] ([ID_funcao], [sigla], [descricao]) VALUES (10, N'E.', N'ESTAGIARIO                                                  ')
INSERT [ACESSO].[FUNCAO] ([ID_funcao], [sigla], [descricao]) VALUES (1, N'G.P.', N'GERENTE DE PROJETOS                                         ')
INSERT [ACESSO].[FUNCAO] ([ID_funcao], [sigla], [descricao]) VALUES (4, N'PRO.', N'PROGRAMADOR                                                 ')
INSERT [ACESSO].[FUNCAO] ([ID_funcao], [sigla], [descricao]) VALUES (6, N'TES.', N'TESTADOR                                                    ')
SET IDENTITY_INSERT [ACESSO].[FUNCAO] OFF
/****** Object:  Table [PROJETO].[PONTO_COMPLEXIDADE_ARQUIVOS_INTERNOS]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[PONTO_COMPLEXIDADE_ARQUIVOS_INTERNOS](
	[ID_pontoArquivosInternos] [int] IDENTITY(1,1) NOT NULL,
	[ID_complexidadeNivel] [int] NULL,
	[minTED] [int] NOT NULL,
	[maxTED] [int] NOT NULL,
	[minTER] [int] NOT NULL,
	[maxTER] [int] NOT NULL
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [PROJETO].[PONTO_COMPLEXIDADE_ARQUIVOS_INTERNOS] ON
INSERT [PROJETO].[PONTO_COMPLEXIDADE_ARQUIVOS_INTERNOS] ([ID_pontoArquivosInternos], [ID_complexidadeNivel], [minTED], [maxTED], [minTER], [maxTER]) VALUES (1, 1, 1, 19, 1, 1)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_ARQUIVOS_INTERNOS] ([ID_pontoArquivosInternos], [ID_complexidadeNivel], [minTED], [maxTED], [minTER], [maxTER]) VALUES (2, 1, 20, 50, 1, 1)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_ARQUIVOS_INTERNOS] ([ID_pontoArquivosInternos], [ID_complexidadeNivel], [minTED], [maxTED], [minTER], [maxTER]) VALUES (3, 2, 51, 1000, 1, 1)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_ARQUIVOS_INTERNOS] ([ID_pontoArquivosInternos], [ID_complexidadeNivel], [minTED], [maxTED], [minTER], [maxTER]) VALUES (4, 1, 1, 19, 2, 5)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_ARQUIVOS_INTERNOS] ([ID_pontoArquivosInternos], [ID_complexidadeNivel], [minTED], [maxTED], [minTER], [maxTER]) VALUES (5, 2, 20, 50, 2, 5)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_ARQUIVOS_INTERNOS] ([ID_pontoArquivosInternos], [ID_complexidadeNivel], [minTED], [maxTED], [minTER], [maxTER]) VALUES (6, 3, 51, 1000, 2, 5)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_ARQUIVOS_INTERNOS] ([ID_pontoArquivosInternos], [ID_complexidadeNivel], [minTED], [maxTED], [minTER], [maxTER]) VALUES (7, 2, 1, 19, 6, 1000)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_ARQUIVOS_INTERNOS] ([ID_pontoArquivosInternos], [ID_complexidadeNivel], [minTED], [maxTED], [minTER], [maxTER]) VALUES (11, 3, 20, 50, 6, 1000)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_ARQUIVOS_INTERNOS] ([ID_pontoArquivosInternos], [ID_complexidadeNivel], [minTED], [maxTED], [minTER], [maxTER]) VALUES (14, 3, 51, 1000, 6, 1000)
SET IDENTITY_INSERT [PROJETO].[PONTO_COMPLEXIDADE_ARQUIVOS_INTERNOS] OFF
/****** Object:  Table [PROJETO].[PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS](
	[ID_caracteristicasGeraisDosSistemas] [int] IDENTITY(1,1) NOT NULL,
	[valor] [nvarchar](100) NOT NULL,
	[descricaoGeral] [nvarchar](300) NOT NULL,
	[itensObservados] [nvarchar](1000) NOT NULL,
	[pontosObservados] [nvarchar](1500) NULL,
 CONSTRAINT [PK_PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS] PRIMARY KEY CLUSTERED 
(
	[ID_caracteristicasGeraisDosSistemas] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [PROJETO].[PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS] ON
INSERT [PROJETO].[PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS] ([ID_caracteristicasGeraisDosSistemas], [valor], [descricaoGeral], [itensObservados], [pontosObservados]) VALUES (1, N'Comunicação de dados', N'os aspectos relacionados aos recursos utilizados para a comunicação de dados do sistema deverão ser descritos de forma global. Descrever se a aplicação utiliza protocolos diferentes para recebimento/envio das informações do sistema.', N'não descritos', N'0. Aplicação batch ou funciona stand-alone; 1. Aplicação batch, mas utiliza entrada de dados ou impressão remota;2. Aplicação batch, mas utiliza entrada de dados e impressão remota;3. Aplicação com entrada de dados on-line para alimentar processamento batch ou sistema de consulta;4. Aplicação com entrada de dados on-line, mas suporta apenas um tipo de protocolo de comunicação;5. Aplicação com entrada de dados on-line e suporta mais de um tipo de protocolo de comunicação.')
INSERT [PROJETO].[PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS] ([ID_caracteristicasGeraisDosSistemas], [valor], [descricaoGeral], [itensObservados], [pontosObservados]) VALUES (2, N'Processamento de Dados Distribuído', N'Esta característica refere-se a sistemas que utilizam dados ou processamento distribuído, valendo-se de diversas CPUs.', N'não descritos', N'0. Aplicação não auxilia na transferência de dados ou funções entre os processadores da empresa;1. Aplicação prepara dados para o usuário final utilizar em outro processador (do usuário final), tal como planilhas;2. Aplicação prepara dados para transferência, transfere-os para serem processados em outro equipamento da empresa (não pelo usuário final);3. Processamento é distribuído e a transferência de dados é on-line e apenas em uma direção;4. Processamento é distribuído e a transferência de dados é on-line e em ambas as direções;5. As funções de processamento são dinamicamente executadas no equipamento (CPU) mais apropriada;')
INSERT [PROJETO].[PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS] ([ID_caracteristicasGeraisDosSistemas], [valor], [descricaoGeral], [itensObservados], [pontosObservados]) VALUES (3, N'Desempenho', N'Trata-se de parâmetros estabelecidos pelo usuário como aceitáveis, relativos a tempo de resposta.', N'não descritos', N'0. Nenhum requisito especial de desempenho foi solicitado pelo usuário;1. Requisitos de desempenho foram estabelecidos e revistos, mas nenhuma ação especial foi requerida;2. Tempo de resposta e volume de processamento são itens críticos durante horários de pico de processamento. Nenhuma determinação especial para a utilização do processador foi estabelecida. A data limite para a disponibilidade de processamento é sempre o próximo dia útil;3. Tempo de resposta e volume de processamento são itens críticos durante todo o horário comercial. Nenhuma determinação especial para a utilização do processador foi estabelecida. A data-limite necessária para a comunicação com outros sistemas é limitante.4. Os requisitos de desempenho estabelecidos requerem tarefas de análise de desempenho na fase de planejamento e análise da aplicação.5. Além do descrito no item anterior, ferramentas de análise de desempenho foram usadas nas fases de planejamento, desenvolvimento e/ou implementação para atingir os requisitos de desempenho estabelecidos pelos usuários.')
INSERT [PROJETO].[PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS] ([ID_caracteristicasGeraisDosSistemas], [valor], [descricaoGeral], [itensObservados], [pontosObservados]) VALUES (4, N'Utilização do Equipamento', N'Trata-se de observações quanto ao nível de utilização de equipamentos requerido para a execução do sistema. Este aspecto é observado com vista a planejamento de capacidades e custos.', N'não descritos', N'0. Nenhuma restrição operacional explícita ou mesmo implícita foi incluída.1. Existem restrições operacionais leves. Não é necessário esforço especial para atender às restrições.2. Algumas considerações de ajuste de desempenho e segurança são necessárias.3. São necessárias especificações especiais de processador para um módulo específico da aplicação.4. Restrições operacionais requerem cuidados especiais no processador central ou no processador dedicado para executar a aplicação.5. Além das características do item anterior, há considerações especiais que exigem utilização de ferramentas de análise de desempenho, para a distribuição do sistema e seus componentes, nas unidades processadoras.')
INSERT [PROJETO].[PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS] ([ID_caracteristicasGeraisDosSistemas], [valor], [descricaoGeral], [itensObservados], [pontosObservados]) VALUES (5, N'Volume de transações', N'Consiste na avaliação do nível de influência do volume de transações no projeto, desenvolvimento, implantação e manutenção do sistema.', N'não descritos', N'0. Não estão previstos períodos de picos de volume de transação.1. Estão previstos picos de transações mensalmente, trimestralmente, anualmente ou em certo período do ano.2. São previstos picos semanais.3. São previstos picos diários.4. Alto volume de transações foi estabelecido pelo usuário, ou o tempo de resposta necessário atinge nível alto o suficiente para requerer análise de desempenho na fase de projeto.5. Além do descrito no item anterior, é necessário utilizar ferramentas de análise de desempenho nas fases de projeto, desenvolvimento e/ou implantação.')
INSERT [PROJETO].[PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS] ([ID_caracteristicasGeraisDosSistemas], [valor], [descricaoGeral], [itensObservados], [pontosObservados]) VALUES (6, N'Entrada de dados on-line', N'A análise desta característica permite quantificar o nível de influência exercida pela utilização de entrada de dados no modo on-line no sistema.', N'não descritos', N'0. Todas as transações são processadas em modo batch.1. De 1% a 7% das transações são entradas de dados on-line.2. De 8% a 15% das transações são entradas de dados on-line.3. De 16% a 23% das transações são entradas de dados on-line.')
INSERT [PROJETO].[PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS] ([ID_caracteristicasGeraisDosSistemas], [valor], [descricaoGeral], [itensObservados], [pontosObservados]) VALUES (7, N'Usabilidade', N'a análise desta característica permite quantificar o grau de influência relativo aos recursos implementados com vista a tornar o sistema amigável, permitindo incrementos na eficiência e satisfação do usuário final.', N'(a) - Auxílio à navegação (teclas de função, acesso direto e menus dinâmicos), (b) - Menus Documentação e help on-line, (c) - Movimento automático do cursor, (d) - Movimento horizontal e vertical de tela, (e) - Impressão remota (via transações on-line), (f) - Teclas de função preestabelecidas, (g) - Processos batch submetidos a partir de transações on-line, (h) - Utilização intensa de campos com vídeo reverso, intensificados, sublinhados, coloridos e outros indicadores, (i) - Impressão da documentação das transações on-line através de hard copy, (j) - Utilização de mouse, (l) - Menus pop-up, (m) - O menor número possível de telas para executar as funções de negócio, (n) - Suporte bilingüe (contar como 4 itens), (n) - Suporte multilíngüe. (contar como 6 itens)', N'0. Nenhum dos itens descritos.1. De um a três itens descritos.2. De quatro a cinco dos itens descritos.3. Mais de cinco dos itens descritos, mas não há requisitos específicos do usuário quanto a usabilidade do sistema.4. Mais de cinco dos itens descritos e foram estabelecidos requisitos quanto à usabilidade fortes o suficiente para gerarem atividades específicas envolvendo fatores, tais como minimização da digitação, para mostrar inicialmente os valores utilizados com mais freqüência.5. Mais de cinco dos itens descritos e foram estabelecidos requisitos quanto à usabilidade fortes o suficiente para requerer ferramentas e processos especiais para demonstrar antecipadamente que os objetivos foram alcançados.')
INSERT [PROJETO].[PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS] ([ID_caracteristicasGeraisDosSistemas], [valor], [descricaoGeral], [itensObservados], [pontosObservados]) VALUES (8, N'Atualizações on-line', N'Mede a influência no desenvolvimento do sistema face à utilização de recursos que visem a atualização dos Arquivos Lógicos Internos, no modo on-line.', N'não descritos', N'0. Nenhuma.1. Atualização on-line de um a três arquivos lógicos internos. O volume de atualização é baixo e a recuperação de dados é simples.2. Atualização on-line de mais de três arquivos lógicos internos. O volume de atualização é baixo e a recuperação dos dados é simples.3. Atualização on-line da maioria dos arquivos lógicos internos.4. Em adição ao item anterior, é necessário proteção contra perdas de dados que foi projetada e programada no sistema.5. Além do item anterior, altos volumes trazem considerações de custo no processo de recuperação. Processos para automatizar a recuperação foram incluídos minimizando a intervenção do operador.')
INSERT [PROJETO].[PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS] ([ID_caracteristicasGeraisDosSistemas], [valor], [descricaoGeral], [itensObservados], [pontosObservados]) VALUES (9, N'Processamento complexo', N'a complexidade de processamento influencia no dimensionamento do sistema, e, portanto, deve ser quantificado o seu grau de influência', N'(a) - Processamento especial de auditoria e/ou processamento especial de segurança foram considerados na aplicação, (b) - Processamento lógico extensivo, (c) - Processamento matemático extensivo, (d) - Processamento gerando muitas exceções, resultando em transações incompletas que devem ser processadas novamente. Exemplo: transações de auto-atendimento bancário interrompidas por problemas de comunicação ou com dados incompletos, (e) - Processamento complexo para manusear múltiplas possibilidades de entrada/saída. Exemplo: multimídia', N'0. Nenhum dos itens descritos.1. Apenas um dos itens descritos.2. Dois dos itens descritos.3. Três dos itens descritos.4. Quatro dos itens descritos.5. Todos os cinco itens descritos.')
INSERT [PROJETO].[PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS] ([ID_caracteristicasGeraisDosSistemas], [valor], [descricaoGeral], [itensObservados], [pontosObservados]) VALUES (10, N'Reusabilidade', N'a preocupação com o reaproveitamento de parte dos programas de uma aplicação em outras aplicações implica em cuidados com padronização. O grau de influência no dimensionamento do sistema é quantificado.', N'não descritos', N'0. Nenhuma preocupação com reutilização de código.1. Código reutilizado foi usado somente dentro da aplicação.2. Menos de 10% da aplicação foi projetada prevendo utilização posterior do código por outra aplicação.3. 10% ou mais da aplicação foi projetada prevendo utilização posterior do código por outra aplicação.4. A aplicação foi especificamente projetada e/ou documentada para ter seu código reutilizado por outra aplicação e a aplicação é customizada pelo usuário em nível de código -fonte.5. A aplicação foi especificamente projetada e/ou documentada para ter seu código facilmente reutilizado por outra aplicação e a aplicação é customizada para uso através de parâmetros que podem ser alterados pelo usuário.')
INSERT [PROJETO].[PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS] ([ID_caracteristicasGeraisDosSistemas], [valor], [descricaoGeral], [itensObservados], [pontosObservados]) VALUES (11, N'Facilidade de implantação', N'a quantificação do grau de influência desta característica é feita, observando-se o plano de conversão e implantação e/ou ferramentas utilizadas durante a fase de testes do sistema.', N'não descritos', N'0. Nenhuma consideração especial foi estabelecida pelo usuário e nenhum procedimento especial é requerido na implantação.1. Nenhuma consideração especial foi estabelecida pelo usuário, mas procedimentos especiais são necessários na implementação.2. Requisitos de conversão e implantação foram estabelecidos pelo usuário e roteiro de conversão e implantação foram providos e testados. O impacto da conversão no projeto não é considerado importante.3. Requisitos de conversão e implantação foram estabelecidos pelo usuário e roteiro de conversão e implantação foram providos e testados. O impacto da conversão no projeto é considerado importante.4. Além do item 2, conversão automática e ferramentas de implantação foram providas e testadas.5. Além do item 3, conversão automática e ferramentas de implantação foram providas e testadas.')
INSERT [PROJETO].[PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS] ([ID_caracteristicasGeraisDosSistemas], [valor], [descricaoGeral], [itensObservados], [pontosObservados]) VALUES (12, N'Facilidade operacional', N'a análise desta característica permite quantificar o nível de influência na aplicação, com relação a procedimentos operacionais automáticos que reduzem os procedimentos manuais, bem como mecanismos de inicialização, salvamento e recuperação, verificados durante os testes do sistema.', N'não descritos', N'0. Nenhuma consideração especial de operação, além do processo normal de salvamento foi estabelecida pelo usuário.1-4. Verifique quais das seguintes afirmativas podem ser identificadas na aplicação. Selecione as que forem aplicadas. Cada item vale um ponto, exceto se definido explicitamente:* Foram desenvolvidos processos de inicialização, salvamento e recuperação, mas a intervenção do operador é necessária.* Foram estabelecidos processos de inicialização, salvamento e recuperação, e nenhuma intervenção do operador é necessária (conte como dois itens)* A aplicação minimiza a necessidade de montar fitas magnéticas.* A aplicação minimiza a necessidade de manuseio de papel.5. A aplicação foi desenhada para trabalhar sem operador, nenhuma intervenção do operador é necessária para operar o sistema além de executar e encerrar a aplicação. A aplicação possui rotinas automáticas para recuperação em caso de erro.')
INSERT [PROJETO].[PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS] ([ID_caracteristicasGeraisDosSistemas], [valor], [descricaoGeral], [itensObservados], [pontosObservados]) VALUES (13, N'Múltiplos Locais e Organizações do Usuário', N'consiste na análise da arquitetura do projeto, observando-se a necessidade de instalação do sistema em diversos lugares.', N'não descritos', N'0. Os requisitos do usuário não consideraram a necessidade de instalação em mais de um local.1. A necessidade de múltiplos locais foi considerada no projeto e a aplicação foi desenhada para operar apenas em ambientes de software e hardware idênticos.2. A necessidade de múltiplos locais foi considerada no projeto e a aplicação está preparada para trabalhar apenas em ambientes similares de software e hardware.3. A necessidade de múltiplos locais foi considerada no projeto e a aplicação está preparada para trabalhar em diferentes ambientes de hardware e/ou software.4. Plano de documentação e manutenção foram providos e testados para suportar a aplicação em múltiplos locais, além disso, os itens 1 ou 2 caracterizam a aplicação.5. Plano de documentação e manutenção foram providos e testados para suportar a aplicação em múltiplos locais, além disso, o item 3 caracteriza a aplicação.')
INSERT [PROJETO].[PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS] ([ID_caracteristicasGeraisDosSistemas], [valor], [descricaoGeral], [itensObservados], [pontosObservados]) VALUES (14, N'Facilidade de mudanças', N'focaliza a preocupação com a influencia da manutenção no desenvolvimento do sistema. Esta influência deve ser quantificada baseando na observação', N'(a) - disponibilidade de facilidades como consultas e relatórios flexíveis para atender necessidades simples (conte como 1 item), (b) - disponibilidade de facilidades como consultas e relatórios flexíveis para atender necessidades de complexidade média (conte como 2 itens), (c) - disponibilidade de facilidades como consultas e relatórios flexíveis para atender necessidades complexas (conte 3 itens), (d) - se os dados de controle são armazenados em tabelas que são mantidas pelo usuário através de processos on-line, mas mudanças têm efeitos somente no dia seguinte, (e) - se os dados de controle são armazenados em tabelas que são mantidas pelo usuário através de processos on-line, as mudanças têm efeito imediatamente (conte como 2 itens)', N'0. Nenhum dos itens descritos.1. Um dos itens descritos.2. Dois dos itens descritos.3. Três dos itens descritos.4. Quatro dos itens descritos.5. Todos os cinco itens descritos.')
SET IDENTITY_INSERT [PROJETO].[PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS] OFF
/****** Object:  Table [REQUISITOS].[DOCUMENTO_REQUISITOS_TIPO]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [REQUISITOS].[DOCUMENTO_REQUISITOS_TIPO](
	[ID_documentoRequisitosTipo] [int] IDENTITY(1,1) NOT NULL,
	[nome] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_REQUISITOS_AADSP_DOCUMENTO_REQUISITOS_TIPO] PRIMARY KEY CLUSTERED 
(
	[ID_documentoRequisitosTipo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [REQUISITOS].[DOCUMENTO_REQUISITOS_TIPO] ON
INSERT [REQUISITOS].[DOCUMENTO_REQUISITOS_TIPO] ([ID_documentoRequisitosTipo], [nome]) VALUES (1, N'CASO DE USO')
INSERT [REQUISITOS].[DOCUMENTO_REQUISITOS_TIPO] ([ID_documentoRequisitosTipo], [nome]) VALUES (2, N'HISTÓRIAS DE USUÁRIO')
SET IDENTITY_INSERT [REQUISITOS].[DOCUMENTO_REQUISITOS_TIPO] OFF
/****** Object:  Table [REQUISITOS].[DOCUMENTO_REQUISITOS_TEMPLATE]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [REQUISITOS].[DOCUMENTO_REQUISITOS_TEMPLATE](
	[ID_documentoRequisitosTemplate] [int] IDENTITY(1,1) NOT NULL,
	[nome] [nvarchar](100) NOT NULL,
	[introducao] [nvarchar](500) NOT NULL,
	[visaoGeral] [nvarchar](500) NOT NULL,
	[convencoesTermoAbreviacoes] [nvarchar](500) NOT NULL,
	[identificacaoDosRequisitos] [nvarchar](500) NOT NULL,
	[descricaoReferencia] [nvarchar](300) NOT NULL,
	[descricaoGeralSistema] [nvarchar](500) NOT NULL,
	[abrangenciaSistemasRelacionados] [nvarchar](500) NOT NULL,
	[descricaoGeralAtores] [nvarchar](300) NOT NULL,
	[descricaoRequisitosFuncionais] [nvarchar](500) NOT NULL,
	[descricaoRequisitosNFuncionais] [nvarchar](500) NOT NULL,
 CONSTRAINT [PK_REQUISITOS_AADSP_DOCUMENTO_REQUISITOS_TEMPLATE] PRIMARY KEY CLUSTERED 
(
	[ID_documentoRequisitosTemplate] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [REQUISITOS].[DOCUMENTO_REQUISITOS_TEMPLATE] ON
INSERT [REQUISITOS].[DOCUMENTO_REQUISITOS_TEMPLATE] ([ID_documentoRequisitosTemplate], [nome], [introducao], [visaoGeral], [convencoesTermoAbreviacoes], [identificacaoDosRequisitos], [descricaoReferencia], [descricaoGeralSistema], [abrangenciaSistemasRelacionados], [descricaoGeralAtores], [descricaoRequisitosFuncionais], [descricaoRequisitosNFuncionais]) VALUES (1, N'Modelo básico', N'Este documento especifica o sistema ........., fornecendo aos desenvolvedores informações necessárias para o projeto e implementação, assim como para a realização dos testes e homologação do sistema.', N'Esta introdução fornece as informações necessárias para fazer um bom uso deste documento, explicitando seus objetivos e as convenções que foram adotadas no texto, além de conter uma lista de referências para outros documentos relacionados. As demais seções apresentam a especificação do sistema e estão organizadas em:', N'Esta subseção deve descrever as convenções, termos e abreviações necessários para interpretar apropriadamente este documento. As explicações necessárias podem ser fornecidas diretamente nesta seção ou através de referências para outros documentos ou para apêndices deste documento. ', N'Por convenção, a referência a requisitos é feita através do nome da subseção onde eles estão descritos, seguido do identificador do requisito, de acordo com o esquema abaixo:', N'Para estabelecer a prioridade dos requisitos foram adotadas as denominações “essencial”, “importante” e “desejável”. ', N'O módulo ........... visa abranger um conjunto de documentos e informações disponibilizados pelos dirigentes das entidades aos órgãos interessados e autoridades, de forma a possibilitar a apreciação, conhecimento e julgamento das contas e da gestão dos administradores das entidades, segundo as competências de cada órgão e autoridade, na periodicidade estabelecida no estatuto social ou na lei.', N'O sistema ..... deve permitir o acompanhamento dos gastos dos projetos administrados pela .... e sendo disponibilizando no portal da transparência conforme especificado em Lei (Lei nº 12.527, de 18 de novembro de 2011). Este modulo será desenvolvido e agrupado ao conjunto de módulos contidos no Enterprise Resource Planning – ERP / .... ', N'É descrito os aspectos gerais, relacionados a todos os usuários nas subseções abaixo e as características específicas de cada usuário.', N'Cada um dos casos de uso é descrito em um bloco específico, seguindo o modelo descrito abaixo. O identificador do bloco deve conter o número do caso de uso (por exemplo, [RF001]) e o seu nome. ', N'Esta seção contém os requisitos não funcionais do sistema. Para uma melhor organização deste documento, utilizamos as subseções abaixo para agrupar os requisitos não funcionais relacionados. Naturalmente, o número e tipo de subseções utilizadas depende do sistema que está sendo especificado. ')
SET IDENTITY_INSERT [REQUISITOS].[DOCUMENTO_REQUISITOS_TEMPLATE] OFF
/****** Object:  Table [TAP].[EMPRESA]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [TAP].[EMPRESA](
	[ID_empresa] [int] IDENTITY(1,1) NOT NULL,
	[razaoSocial] [nvarchar](100) NOT NULL,
	[cnpj] [nvarchar](60) NOT NULL,
	[cpf] [nvarchar](60) NOT NULL,
	[telefone] [nvarchar](20) NOT NULL,
	[email] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_TAP_AADSP_EMPRESA] PRIMARY KEY CLUSTERED 
(
	[ID_empresa] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [TAP].[EMPRESA] ON
INSERT [TAP].[EMPRESA] ([ID_empresa], [razaoSocial], [cnpj], [cpf], [telefone], [email]) VALUES (1, N'FAPEX', N'0000000000000', N'000000000000', N'(055) 071-3259 x3831', N'felipe.pereora.coelho@gmail.com')
SET IDENTITY_INSERT [TAP].[EMPRESA] OFF
/****** Object:  Table [PROJETO].[EAP_TIPO]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[EAP_TIPO](
	[ID_eapTipo] [int] IDENTITY(1,1) NOT NULL,
	[descricao] [nvarchar](60) NOT NULL,
 CONSTRAINT [PK_PROJETO_AADSP_DIAGRAMA_EAP_TIPO] PRIMARY KEY CLUSTERED 
(
	[ID_eapTipo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [PROJETO].[EAP_TIPO] ON
INSERT [PROJETO].[EAP_TIPO] ([ID_eapTipo], [descricao]) VALUES (1, N'PACOTE')
INSERT [PROJETO].[EAP_TIPO] ([ID_eapTipo], [descricao]) VALUES (2, N'FASE')
INSERT [PROJETO].[EAP_TIPO] ([ID_eapTipo], [descricao]) VALUES (3, N'ENTREGAS')
SET IDENTITY_INSERT [PROJETO].[EAP_TIPO] OFF
/****** Object:  Table [PROJETO].[DIAGRAMA_UML_TIPO]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[DIAGRAMA_UML_TIPO](
	[ID_diagramaUMLTipo] [int] IDENTITY(1,1) NOT NULL,
	[descricao] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_PROJETO_AADSP_DIAGRAMA_UML_TIPO] PRIMARY KEY CLUSTERED 
(
	[ID_diagramaUMLTipo] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [PROJETO].[DIAGRAMA_UML_TIPO] ON
INSERT [PROJETO].[DIAGRAMA_UML_TIPO] ([ID_diagramaUMLTipo], [descricao]) VALUES (1, N'Diagrama de Classes')
INSERT [PROJETO].[DIAGRAMA_UML_TIPO] ([ID_diagramaUMLTipo], [descricao]) VALUES (2, N'Diagrama de Caso de Uso')
INSERT [PROJETO].[DIAGRAMA_UML_TIPO] ([ID_diagramaUMLTipo], [descricao]) VALUES (3, N'Diagrama de Objetos')
INSERT [PROJETO].[DIAGRAMA_UML_TIPO] ([ID_diagramaUMLTipo], [descricao]) VALUES (4, N'Diagrama de Pacotes')
INSERT [PROJETO].[DIAGRAMA_UML_TIPO] ([ID_diagramaUMLTipo], [descricao]) VALUES (5, N'Diagrama de Componentes')
INSERT [PROJETO].[DIAGRAMA_UML_TIPO] ([ID_diagramaUMLTipo], [descricao]) VALUES (6, N'Diagrama de Sequência')
INSERT [PROJETO].[DIAGRAMA_UML_TIPO] ([ID_diagramaUMLTipo], [descricao]) VALUES (7, N'Diagrama de Atividades')
INSERT [PROJETO].[DIAGRAMA_UML_TIPO] ([ID_diagramaUMLTipo], [descricao]) VALUES (8, N'Diagrama de Estados')
INSERT [PROJETO].[DIAGRAMA_UML_TIPO] ([ID_diagramaUMLTipo], [descricao]) VALUES (9, N'Diagrama de Implantação')
INSERT [PROJETO].[DIAGRAMA_UML_TIPO] ([ID_diagramaUMLTipo], [descricao]) VALUES (10, N'Diagrama de Colaboração')
INSERT [PROJETO].[DIAGRAMA_UML_TIPO] ([ID_diagramaUMLTipo], [descricao]) VALUES (11, N'Diagrama de Estrutura')
INSERT [PROJETO].[DIAGRAMA_UML_TIPO] ([ID_diagramaUMLTipo], [descricao]) VALUES (12, N'Diagrama de Tempo')
INSERT [PROJETO].[DIAGRAMA_UML_TIPO] ([ID_diagramaUMLTipo], [descricao]) VALUES (13, N'Diagrama de Interatividade')
SET IDENTITY_INSERT [PROJETO].[DIAGRAMA_UML_TIPO] OFF
/****** Object:  Table [COLABORADOR].[COLABORADOR]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [COLABORADOR].[COLABORADOR](
	[ID_colaborador] [int] IDENTITY(1,1) NOT NULL,
	[ID_usuario] [int] NOT NULL,
	[numeroPIS] [varchar](60) NOT NULL,
	[dataContrato] [datetime] NOT NULL,
	[valorBruto] [decimal](18, 2) NOT NULL,
 CONSTRAINT [PK_COLABORADOR_AADSP_COLABORADOR] PRIMARY KEY CLUSTERED 
(
	[ID_colaborador] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [COLABORADOR].[COLABORADOR] ON
INSERT [COLABORADOR].[COLABORADOR] ([ID_colaborador], [ID_usuario], [numeroPIS], [dataContrato], [valorBruto]) VALUES (1, 1, N'9888888889', CAST(0x0000A60600000000 AS DateTime), CAST(1253.00 AS Decimal(18, 2)))
SET IDENTITY_INSERT [COLABORADOR].[COLABORADOR] OFF
/****** Object:  Table [TAP].[PATROCINADOR]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [TAP].[PATROCINADOR](
	[ID_patrocinador] [int] IDENTITY(1,1) NOT NULL,
	[ID_tap] [int] NOT NULL,
	[ID_stakeholder] [int] NULL,
	[ID_empresa] [int] NULL,
 CONSTRAINT [PK_TAP_AADSP_PATROCINADOR] PRIMARY KEY CLUSTERED 
(
	[ID_patrocinador] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [TAP].[PATROCINADOR] ON
INSERT [TAP].[PATROCINADOR] ([ID_patrocinador], [ID_tap], [ID_stakeholder], [ID_empresa]) VALUES (3, 7, NULL, 1)
INSERT [TAP].[PATROCINADOR] ([ID_patrocinador], [ID_tap], [ID_stakeholder], [ID_empresa]) VALUES (4, 7, 5, NULL)
INSERT [TAP].[PATROCINADOR] ([ID_patrocinador], [ID_tap], [ID_stakeholder], [ID_empresa]) VALUES (5, 17, 5, NULL)
SET IDENTITY_INSERT [TAP].[PATROCINADOR] OFF
/****** Object:  Table [TAP].[EQUIPE]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [TAP].[EQUIPE](
	[ID_equipe] [int] IDENTITY(1,1) NOT NULL,
	[ID_funcao] [int] NOT NULL,
	[ID_tap] [int] NOT NULL,
 CONSTRAINT [PK_TAP_AADSP_EQUIPE] PRIMARY KEY CLUSTERED 
(
	[ID_equipe] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [TAP].[EQUIPE] ON
INSERT [TAP].[EQUIPE] ([ID_equipe], [ID_funcao], [ID_tap]) VALUES (1, 28, 7)
INSERT [TAP].[EQUIPE] ([ID_equipe], [ID_funcao], [ID_tap]) VALUES (3, 9, 17)
INSERT [TAP].[EQUIPE] ([ID_equipe], [ID_funcao], [ID_tap]) VALUES (4, 8, 17)
SET IDENTITY_INSERT [TAP].[EQUIPE] OFF
/****** Object:  Table [PROJETO].[PONTO_COMPLEXIDADE_ENTRADAS_EXTERNAS]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[PONTO_COMPLEXIDADE_ENTRADAS_EXTERNAS](
	[ID_pontoEntradasExternas] [int] IDENTITY(1,1) NOT NULL,
	[ID_complexidadeNivel] [int] NOT NULL,
	[minTED] [int] NOT NULL,
	[maxTED] [int] NOT NULL,
	[minTAR] [int] NOT NULL,
	[maxTAR] [int] NOT NULL,
 CONSTRAINT [PK_PROJETO_AADSP_PROJETO_PONTO_COMPLEXIDADE_ENTRADAS_EXTERNAS] PRIMARY KEY CLUSTERED 
(
	[ID_pontoEntradasExternas] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [PROJETO].[PONTO_COMPLEXIDADE_ENTRADAS_EXTERNAS] ON
INSERT [PROJETO].[PONTO_COMPLEXIDADE_ENTRADAS_EXTERNAS] ([ID_pontoEntradasExternas], [ID_complexidadeNivel], [minTED], [maxTED], [minTAR], [maxTAR]) VALUES (2, 1, 1, 4, 0, 1)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_ENTRADAS_EXTERNAS] ([ID_pontoEntradasExternas], [ID_complexidadeNivel], [minTED], [maxTED], [minTAR], [maxTAR]) VALUES (3, 1, 5, 15, 0, 1)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_ENTRADAS_EXTERNAS] ([ID_pontoEntradasExternas], [ID_complexidadeNivel], [minTED], [maxTED], [minTAR], [maxTAR]) VALUES (4, 2, 16, 1000, 0, 1)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_ENTRADAS_EXTERNAS] ([ID_pontoEntradasExternas], [ID_complexidadeNivel], [minTED], [maxTED], [minTAR], [maxTAR]) VALUES (5, 1, 1, 4, 2, 2)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_ENTRADAS_EXTERNAS] ([ID_pontoEntradasExternas], [ID_complexidadeNivel], [minTED], [maxTED], [minTAR], [maxTAR]) VALUES (6, 2, 5, 15, 2, 2)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_ENTRADAS_EXTERNAS] ([ID_pontoEntradasExternas], [ID_complexidadeNivel], [minTED], [maxTED], [minTAR], [maxTAR]) VALUES (7, 3, 16, 1000, 2, 2)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_ENTRADAS_EXTERNAS] ([ID_pontoEntradasExternas], [ID_complexidadeNivel], [minTED], [maxTED], [minTAR], [maxTAR]) VALUES (8, 2, 1, 4, 3, 1000)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_ENTRADAS_EXTERNAS] ([ID_pontoEntradasExternas], [ID_complexidadeNivel], [minTED], [maxTED], [minTAR], [maxTAR]) VALUES (9, 3, 5, 15, 3, 1000)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_ENTRADAS_EXTERNAS] ([ID_pontoEntradasExternas], [ID_complexidadeNivel], [minTED], [maxTED], [minTAR], [maxTAR]) VALUES (10, 3, 16, 1000, 3, 1000)
SET IDENTITY_INSERT [PROJETO].[PONTO_COMPLEXIDADE_ENTRADAS_EXTERNAS] OFF
/****** Object:  Table [PROJETO].[PONTO_COMPLEXIDADE_CONTRIBUICAO]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[PONTO_COMPLEXIDADE_CONTRIBUICAO](
	[ID_pontoContribuicao] [int] IDENTITY(1,1) NOT NULL,
	[ID_complexidadeNivel] [int] NOT NULL,
	[ALI] [int] NOT NULL,
	[AIE] [int] NOT NULL,
	[EE] [int] NOT NULL,
	[SE] [int] NOT NULL,
	[CE] [int] NOT NULL,
 CONSTRAINT [PK_PONTO_COMPLEXIDADE_CONTRIBUICAO] PRIMARY KEY CLUSTERED 
(
	[ID_pontoContribuicao] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [PROJETO].[PONTO_COMPLEXIDADE_CONTRIBUICAO] ON
INSERT [PROJETO].[PONTO_COMPLEXIDADE_CONTRIBUICAO] ([ID_pontoContribuicao], [ID_complexidadeNivel], [ALI], [AIE], [EE], [SE], [CE]) VALUES (1, 1, 7, 5, 3, 4, 3)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_CONTRIBUICAO] ([ID_pontoContribuicao], [ID_complexidadeNivel], [ALI], [AIE], [EE], [SE], [CE]) VALUES (2, 2, 10, 7, 4, 5, 4)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_CONTRIBUICAO] ([ID_pontoContribuicao], [ID_complexidadeNivel], [ALI], [AIE], [EE], [SE], [CE]) VALUES (3, 3, 15, 10, 6, 7, 6)
SET IDENTITY_INSERT [PROJETO].[PONTO_COMPLEXIDADE_CONTRIBUICAO] OFF
/****** Object:  Table [PROJETO].[PONTO_COMPLEXIDADE_SAIDAS_EXTERNAS]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[PONTO_COMPLEXIDADE_SAIDAS_EXTERNAS](
	[ID_pontoEntradasExternas] [int] IDENTITY(1,1) NOT NULL,
	[ID_complexidadeNivel] [int] NOT NULL,
	[minTED] [int] NOT NULL,
	[maxTED] [int] NOT NULL,
	[minTAR] [int] NOT NULL,
	[maxTAR] [int] NOT NULL,
 CONSTRAINT [PK_PONTO_COMPLEXIDADE_SAIDAS_EXTERNAS] PRIMARY KEY CLUSTERED 
(
	[ID_pontoEntradasExternas] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [PROJETO].[PONTO_COMPLEXIDADE_SAIDAS_EXTERNAS] ON
INSERT [PROJETO].[PONTO_COMPLEXIDADE_SAIDAS_EXTERNAS] ([ID_pontoEntradasExternas], [ID_complexidadeNivel], [minTED], [maxTED], [minTAR], [maxTAR]) VALUES (1, 1, 1, 5, 0, 1)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_SAIDAS_EXTERNAS] ([ID_pontoEntradasExternas], [ID_complexidadeNivel], [minTED], [maxTED], [minTAR], [maxTAR]) VALUES (2, 1, 6, 19, 0, 1)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_SAIDAS_EXTERNAS] ([ID_pontoEntradasExternas], [ID_complexidadeNivel], [minTED], [maxTED], [minTAR], [maxTAR]) VALUES (3, 2, 20, 1000, 0, 1)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_SAIDAS_EXTERNAS] ([ID_pontoEntradasExternas], [ID_complexidadeNivel], [minTED], [maxTED], [minTAR], [maxTAR]) VALUES (4, 1, 1, 5, 2, 3)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_SAIDAS_EXTERNAS] ([ID_pontoEntradasExternas], [ID_complexidadeNivel], [minTED], [maxTED], [minTAR], [maxTAR]) VALUES (5, 2, 6, 19, 2, 3)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_SAIDAS_EXTERNAS] ([ID_pontoEntradasExternas], [ID_complexidadeNivel], [minTED], [maxTED], [minTAR], [maxTAR]) VALUES (6, 3, 20, 1000, 2, 3)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_SAIDAS_EXTERNAS] ([ID_pontoEntradasExternas], [ID_complexidadeNivel], [minTED], [maxTED], [minTAR], [maxTAR]) VALUES (7, 2, 1, 5, 4, 1000)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_SAIDAS_EXTERNAS] ([ID_pontoEntradasExternas], [ID_complexidadeNivel], [minTED], [maxTED], [minTAR], [maxTAR]) VALUES (8, 3, 6, 19, 4, 1000)
INSERT [PROJETO].[PONTO_COMPLEXIDADE_SAIDAS_EXTERNAS] ([ID_pontoEntradasExternas], [ID_complexidadeNivel], [minTED], [maxTED], [minTAR], [maxTAR]) VALUES (9, 3, 20, 1000, 4, 1000)
SET IDENTITY_INSERT [PROJETO].[PONTO_COMPLEXIDADE_SAIDAS_EXTERNAS] OFF
/****** Object:  Table [ACESSO].[ACESSO]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [ACESSO].[ACESSO](
	[ID_acesso] [int] IDENTITY(1,1) NOT NULL,
	[ID_funcao] [int] NOT NULL,
	[ID_pagina] [int] NOT NULL,
 CONSTRAINT [PK_ACESSO] PRIMARY KEY CLUSTERED 
(
	[ID_acesso] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [UQAcessoPaginaFuncao] UNIQUE NONCLUSTERED 
(
	[ID_funcao] ASC,
	[ID_pagina] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [ACESSO].[ACESSO] ON
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (1, 1, 1)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (2, 1, 2)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (3, 1, 3)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (4, 1, 4)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (5, 1, 5)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (6, 1, 6)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (7, 1, 7)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (8, 1, 8)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (11, 1, 9)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (12, 1, 10)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (13, 1, 11)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (14, 1, 12)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (17, 1, 13)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (20, 1, 14)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (16, 1, 15)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (18, 1, 16)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (19, 1, 20)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (24, 1, 21)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (26, 1, 22)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (27, 1, 23)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (25, 1, 24)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (30, 1, 25)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (29, 1, 26)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (28, 1, 27)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (32, 1, 28)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (34, 1, 41)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (35, 1, 42)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (36, 1, 43)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (37, 1, 44)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (38, 1, 45)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (42, 1, 46)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (43, 1, 47)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (44, 1, 48)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (45, 1, 49)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (46, 1, 50)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (47, 1, 51)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (48, 1, 52)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (49, 1, 53)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (50, 1, 54)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (51, 1, 55)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (52, 1, 56)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (53, 1, 57)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (54, 1, 58)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (55, 1, 59)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (56, 1, 60)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (57, 1, 61)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (58, 1, 62)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (9, 4, 1)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (40, 5, 21)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (10, 6, 1)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (23, 6, 12)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (15, 10, 1)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (60, 37, 61)
INSERT [ACESSO].[ACESSO] ([ID_acesso], [ID_funcao], [ID_pagina]) VALUES (59, 37, 62)
SET IDENTITY_INSERT [ACESSO].[ACESSO] OFF
/****** Object:  Table [PROJETO].[PROJETO]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[PROJETO](
	[ID_projeto] [int] IDENTITY(1,1) NOT NULL,
	[ID_tap] [int] NOT NULL,
	[dataInicio] [datetime] NOT NULL,
	[dataTermino] [datetime] NOT NULL,
	[dataCadastro] [datetime] NOT NULL,
	[investimento] [decimal](18, 2) NOT NULL,
 CONSTRAINT [PK_PROJETO_AADSP_PROJETO] PRIMARY KEY CLUSTERED 
(
	[ID_projeto] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [PROJETO].[PROJETO] ON
INSERT [PROJETO].[PROJETO] ([ID_projeto], [ID_tap], [dataInicio], [dataTermino], [dataCadastro], [investimento]) VALUES (6, 7, CAST(0x0000A60700000000 AS DateTime), CAST(0x0000A60A00000000 AS DateTime), CAST(0x0000A60700000000 AS DateTime), CAST(10000.00 AS Decimal(18, 2)))
INSERT [PROJETO].[PROJETO] ([ID_projeto], [ID_tap], [dataInicio], [dataTermino], [dataCadastro], [investimento]) VALUES (7, 17, CAST(0x0000A61300000000 AS DateTime), CAST(0x0000A60D00000000 AS DateTime), CAST(0x0000A60D00000000 AS DateTime), CAST(52000.00 AS Decimal(18, 2)))
INSERT [PROJETO].[PROJETO] ([ID_projeto], [ID_tap], [dataInicio], [dataTermino], [dataCadastro], [investimento]) VALUES (8, 18, CAST(0x0000A4E700000000 AS DateTime), CAST(0x0000A61800000000 AS DateTime), CAST(0x0000A62A00000000 AS DateTime), CAST(120000.00 AS Decimal(18, 2)))
INSERT [PROJETO].[PROJETO] ([ID_projeto], [ID_tap], [dataInicio], [dataTermino], [dataCadastro], [investimento]) VALUES (9, 19, CAST(0x0000A63900000000 AS DateTime), CAST(0x0000A64000000000 AS DateTime), CAST(0x0000A63900000000 AS DateTime), CAST(0.00 AS Decimal(18, 2)))
SET IDENTITY_INSERT [PROJETO].[PROJETO] OFF
/****** Object:  Table [TAP].[STAKEHOLDER_TAP]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [TAP].[STAKEHOLDER_TAP](
	[ID_stakeholderTap] [int] IDENTITY(1,1) NOT NULL,
	[ID_stakeholder] [int] NOT NULL,
	[ID_tap] [int] NOT NULL,
 CONSTRAINT [PK_TAP_AADSP_STAKEHOLDER_TAP] PRIMARY KEY CLUSTERED 
(
	[ID_stakeholderTap] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [TAP].[STAKEHOLDER_TAP] ON
INSERT [TAP].[STAKEHOLDER_TAP] ([ID_stakeholderTap], [ID_stakeholder], [ID_tap]) VALUES (2, 5, 7)
INSERT [TAP].[STAKEHOLDER_TAP] ([ID_stakeholderTap], [ID_stakeholder], [ID_tap]) VALUES (5, 6, 7)
INSERT [TAP].[STAKEHOLDER_TAP] ([ID_stakeholderTap], [ID_stakeholder], [ID_tap]) VALUES (8, 5, 17)
SET IDENTITY_INSERT [TAP].[STAKEHOLDER_TAP] OFF
/****** Object:  Table [PROJETO].[RECURSOS_ADICIONAIS]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[RECURSOS_ADICIONAIS](
	[ID_recursosAdicionais] [int] IDENTITY(1,1) NOT NULL,
	[ID_projeto] [int] NOT NULL,
	[descricao] [nvarchar](255) NOT NULL,
	[dataCadastro] [datetime] NOT NULL,
	[valor] [decimal](18, 2) NOT NULL,
 CONSTRAINT [PK_PROJETO_AADSP_PROJETO_RECUROS_ADICIONAIS] PRIMARY KEY CLUSTERED 
(
	[ID_recursosAdicionais] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [PROJETO].[RECURSOS_ADICIONAIS] ON
INSERT [PROJETO].[RECURSOS_ADICIONAIS] ([ID_recursosAdicionais], [ID_projeto], [descricao], [dataCadastro], [valor]) VALUES (4, 6, N'Computador', CAST(0x0000A63100000000 AS DateTime), CAST(0.00 AS Decimal(18, 2)))
INSERT [PROJETO].[RECURSOS_ADICIONAIS] ([ID_recursosAdicionais], [ID_projeto], [descricao], [dataCadastro], [valor]) VALUES (5, 6, N'Mesa', CAST(0x0000A63100000000 AS DateTime), CAST(10000.00 AS Decimal(18, 2)))
SET IDENTITY_INSERT [PROJETO].[RECURSOS_ADICIONAIS] OFF
/****** Object:  Table [PROJETO].[PONTO_CONTAR_TIPO_TRANSACAO]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[PONTO_CONTAR_TIPO_TRANSACAO](
	[ID_contarTipoTransacao] [int] IDENTITY(1,1) NOT NULL,
	[ID_tipoTransacaoTipo] [int] NOT NULL,
	[ID_projeto] [int] NOT NULL,
	[valorTED] [int] NOT NULL,
	[descricaoTED] [nvarchar](100) NOT NULL,
	[valorTAR] [int] NOT NULL,
	[descricaoTAR] [nvarchar](100) NOT NULL,
	[valorTipoTransacao] [int] NOT NULL,
	[descricaoTipoTransacao] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_PONTO_CONTAR_TIPO_TRANSACAO] PRIMARY KEY CLUSTERED 
(
	[ID_contarTipoTransacao] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [PROJETO].[PONTO_CONTAR_TIPO_DADOS_FUNCAO]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[PONTO_CONTAR_TIPO_DADOS_FUNCAO](
	[ID_contarTipoDado] [int] IDENTITY(1,1) NOT NULL,
	[ID_pontoTipoDados] [int] NOT NULL,
	[ID_projeto] [int] NOT NULL,
	[valorTipoDados] [int] NOT NULL,
	[descricaoTipoDados] [nvarchar](100) NOT NULL,
	[valorTED] [int] NOT NULL,
	[descricaoTED] [nvarchar](100) NOT NULL,
	[valorTER] [int] NOT NULL,
	[descricaoTER] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_PONTO_CONTAR_TIPO_DADOS_FUNCAO] PRIMARY KEY CLUSTERED 
(
	[ID_contarTipoDado] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [PROJETO].[PONTO_CONTAR_FATOR_DE_AJUSTE]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[PONTO_CONTAR_FATOR_DE_AJUSTE](
	[ID_fatorDeAjuste] [int] IDENTITY(1,1) NOT NULL,
	[ID_caracteristicasGeraisDosSistemas] [int] NOT NULL,
	[ID_grauInfluencia] [int] NOT NULL,
	[ID_projeto] [int] NOT NULL,
	[justificativa] [nvarchar](1000) NOT NULL,
 CONSTRAINT [PK_PONTO_CONTAR_FATOR_DE_AJUSTE] PRIMARY KEY CLUSTERED 
(
	[ID_fatorDeAjuste] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [PROJETO].[EAP]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[EAP](
	[ID_eap] [int] IDENTITY(1,1) NOT NULL,
	[ID_eapTipo] [int] NULL,
	[ID_projeto] [int] NULL,
	[dataCadastro] [datetime] NULL,
 CONSTRAINT [PK_PROJETO_AADSP_DIAGRAMA_EAP] PRIMARY KEY CLUSTERED 
(
	[ID_eap] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [UC_PROJETO_AADSP_DIAGRAMA_EAP] UNIQUE NONCLUSTERED 
(
	[ID_eapTipo] ASC,
	[ID_projeto] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [PROJETO].[EAP] ON
INSERT [PROJETO].[EAP] ([ID_eap], [ID_eapTipo], [ID_projeto], [dataCadastro]) VALUES (2, 1, 8, CAST(0x0000A62A00000000 AS DateTime))
SET IDENTITY_INSERT [PROJETO].[EAP] OFF
/****** Object:  Table [REQUISITOS].[DOCUMENTO_REQUISITOS]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [REQUISITOS].[DOCUMENTO_REQUISITOS](
	[ID_documentoRequisitos] [int] IDENTITY(1,1) NOT NULL,
	[ID_projeto] [int] NOT NULL,
	[introducao] [nvarchar](500) NOT NULL,
	[visaoGeral] [nvarchar](500) NOT NULL,
	[convencoesTermoAbreviacoes] [nvarchar](500) NOT NULL,
	[identificacaoDosRequisitos] [nvarchar](500) NOT NULL,
	[descricaoReferencia] [nvarchar](300) NOT NULL,
	[descricaoGeralSistema] [nvarchar](500) NOT NULL,
	[abrangenciaSistemasRelacionados] [nvarchar](500) NOT NULL,
	[descricaoGeralAtores] [nvarchar](300) NOT NULL,
	[descricaoRequisitosFuncionais] [nvarchar](500) NOT NULL,
	[descricaoRequisitosNFuncionais] [nvarchar](500) NOT NULL,
	[versao] [decimal](18, 1) NOT NULL,
	[ID_documentoRequisitosTipo] [int] NOT NULL,
	[dataCadastro] [datetime] NOT NULL,
 CONSTRAINT [PK_REQUISITOS_AADSP_DOCUMENTO_REQUISITOS] PRIMARY KEY CLUSTERED 
(
	[ID_documentoRequisitos] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [REQUISITOS].[DOCUMENTO_REQUISITOS] ON
INSERT [REQUISITOS].[DOCUMENTO_REQUISITOS] ([ID_documentoRequisitos], [ID_projeto], [introducao], [visaoGeral], [convencoesTermoAbreviacoes], [identificacaoDosRequisitos], [descricaoReferencia], [descricaoGeralSistema], [abrangenciaSistemasRelacionados], [descricaoGeralAtores], [descricaoRequisitosFuncionais], [descricaoRequisitosNFuncionais], [versao], [ID_documentoRequisitosTipo], [dataCadastro]) VALUES (1, 7, N'Este documento especifica o sistema ........., fornecendo aos desenvolvedores informações necessárias para o projeto e implementação, assim como para a realização dos testes e homologação do sistema.', N'Esta introdução fornece as informações necessárias para fazer um bom uso deste documento, explicitando seus objetivos e as convenções que foram adotadas no texto, além de conter uma lista de referências para outros documentos relacionados. As demais seções apresentam a especificação do sistema e estão organizadas em:', N'Esta subseção deve descrever as convenções, termos e abreviações necessários para interpretar apropriadamente este documento. As explicações necessárias podem ser fornecidas diretamente nesta seção ou através de referências para outros documentos ou para apêndices deste documento. ', N'Por convenção, a referência a requisitos é feita através do nome da subseção onde eles estão descritos, seguido do identificador do requisito, de acordo com o esquema abaixo:', N'Para estabelecer a prioridade dos requisitos foram adotadas as denominações “essencial”, “importante” e “desejável”. ', N'O módulo ........... visa abranger um conjunto de documentos e informações disponibilizados pelos dirigentes das entidades aos órgãos interessados e autoridades, de forma a possibilitar a apreciação, conhecimento e julgamento das contas e da gestão dos administradores das entidades, segundo as competências de cada órgão e autoridade, na periodicidade estabelecida no estatuto social ou na lei.', N'O sistema ..... deve permitir o acompanhamento dos gastos dos projetos administrados pela .... e sendo disponibilizando no portal da transparência conforme especificado em Lei (Lei nº 12.527, de 18 de novembro de 2011). Este modulo será desenvolvido e agrupado ao conjunto de módulos contidos no Enterprise Resource Planning – ERP / .... ', N'É descrito os aspectos gerais, relacionados a todos os usuários nas subseções abaixo e as características específicas de cada usuário.', N'Cada um dos casos de uso é descrito em um bloco específico, seguindo o modelo descrito abaixo. O identificador do bloco deve conter o número do caso de uso (por exemplo, [RF001]) e o seu nome. ', N'Esta seção contém os requisitos não funcionais do sistema. Para uma melhor organização deste documento, utilizamos as subseções abaixo para agrupar os requisitos não funcionais relacionados. Naturalmente, o número e tipo de subseções utilizadas depende do sistema que está sendo especificado. ', CAST(0.0 AS Decimal(18, 1)), 1, CAST(0x0000A61D00000000 AS DateTime))
SET IDENTITY_INSERT [REQUISITOS].[DOCUMENTO_REQUISITOS] OFF
/****** Object:  Table [PROJETO].[ATA]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[ATA](
	[ID_ata] [int] IDENTITY(1,1) NOT NULL,
	[ID_projeto] [int] NOT NULL,
	[ID_colaborador] [int] NOT NULL,
	[titulo] [nvarchar](250) NOT NULL,
	[pauta] [text] NOT NULL,
	[assuntosTratados] [text] NOT NULL,
	[dataCadastro] [datetime] NOT NULL,
	[dataRealizacao] [datetime] NOT NULL,
 CONSTRAINT [PK_PROJETO_AADSP_ATA] PRIMARY KEY CLUSTERED 
(
	[ID_ata] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [PROJETO].[ATA] ON
INSERT [PROJETO].[ATA] ([ID_ata], [ID_projeto], [ID_colaborador], [titulo], [pauta], [assuntosTratados], [dataCadastro], [dataRealizacao]) VALUES (1, 6, 1, N'Teste titulo da ata', N'teste pauta 1', N'teste dicussoes 2', CAST(0x0000A60800000000 AS DateTime), CAST(0x0000A60800000000 AS DateTime))
SET IDENTITY_INSERT [PROJETO].[ATA] OFF
/****** Object:  Table [PROJETO].[DIAGRAMA_UML]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [PROJETO].[DIAGRAMA_UML](
	[ID_diagramaUML] [int] IDENTITY(1,1) NOT NULL,
	[ID_projeto] [int] NOT NULL,
	[ID_diagramaUMLTipo] [int] NOT NULL,
	[imagem] [varchar](100) NOT NULL,
 CONSTRAINT [PK_PROJETO_AADSP_DIAGRAMA_UML] PRIMARY KEY CLUSTERED 
(
	[ID_diagramaUML] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [PROJETO].[DIAGRAMA_UML] ON
INSERT [PROJETO].[DIAGRAMA_UML] ([ID_diagramaUML], [ID_projeto], [ID_diagramaUMLTipo], [imagem]) VALUES (3, 6, 8, N'1464561002204')
INSERT [PROJETO].[DIAGRAMA_UML] ([ID_diagramaUML], [ID_projeto], [ID_diagramaUMLTipo], [imagem]) VALUES (4, 6, 11, N'1465234776164')
INSERT [PROJETO].[DIAGRAMA_UML] ([ID_diagramaUML], [ID_projeto], [ID_diagramaUMLTipo], [imagem]) VALUES (5, 6, 6, N'1465234986902')
SET IDENTITY_INSERT [PROJETO].[DIAGRAMA_UML] OFF
/****** Object:  Table [PROJETO].[CRONOGRAMA]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[CRONOGRAMA](
	[ID_cronograma] [int] IDENTITY(1,1) NOT NULL,
	[ID_projeto] [int] NULL,
	[atividade] [nvarchar](250) NOT NULL,
	[dataInicio] [datetime] NOT NULL,
	[dataTermino] [datetime] NOT NULL,
 CONSTRAINT [PK_PROJETO_AADSP_CRONOGRAMA] PRIMARY KEY CLUSTERED 
(
	[ID_cronograma] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [PROJETO].[CRONOGRAMA] ON
INSERT [PROJETO].[CRONOGRAMA] ([ID_cronograma], [ID_projeto], [atividade], [dataInicio], [dataTermino]) VALUES (5, 6, N'Planejamento', CAST(0x0000A60700000000 AS DateTime), CAST(0x0000A60800000000 AS DateTime))
INSERT [PROJETO].[CRONOGRAMA] ([ID_cronograma], [ID_projeto], [atividade], [dataInicio], [dataTermino]) VALUES (6, 6, N'Codificação', CAST(0x0000A60800000000 AS DateTime), CAST(0x0000A60800000000 AS DateTime))
SET IDENTITY_INSERT [PROJETO].[CRONOGRAMA] OFF
/****** Object:  Table [PROJETO].[EAP_PACOTE]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[EAP_PACOTE](
	[ID_eapPacote] [int] IDENTITY(1,1) NOT NULL,
	[ID_projeto] [int] NOT NULL,
	[descricao] [nvarchar](60) NOT NULL,
 CONSTRAINT [PK_PROJETO_AADSP_DIAGRAMA_EAP_PACOTE] PRIMARY KEY CLUSTERED 
(
	[ID_eapPacote] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [PROJETO].[EAP_PACOTE] ON
INSERT [PROJETO].[EAP_PACOTE] ([ID_eapPacote], [ID_projeto], [descricao]) VALUES (2, 8, N'PRESTAÇÃO DE CONTAS')
INSERT [PROJETO].[EAP_PACOTE] ([ID_eapPacote], [ID_projeto], [descricao]) VALUES (3, 8, N'NOTIFICAÇÃO')
INSERT [PROJETO].[EAP_PACOTE] ([ID_eapPacote], [ID_projeto], [descricao]) VALUES (4, 8, N'TESTE')
SET IDENTITY_INSERT [PROJETO].[EAP_PACOTE] OFF
/****** Object:  Table [PROJETO].[EAP_ATIVIDADE]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [PROJETO].[EAP_ATIVIDADE](
	[ID_eapAtividade] [int] IDENTITY(1,1) NOT NULL,
	[ID_eap] [int] NULL,
	[ID_eapPacote] [int] NULL,
	[descricao] [nvarchar](255) NOT NULL,
 CONSTRAINT [PK_PROJETO_AADSP_DIAGRAMA_EAP_ATIVIDADE] PRIMARY KEY CLUSTERED 
(
	[ID_eapAtividade] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [PROJETO].[EAP_ATIVIDADE] ON
INSERT [PROJETO].[EAP_ATIVIDADE] ([ID_eapAtividade], [ID_eap], [ID_eapPacote], [descricao]) VALUES (3, 2, 2, N'CADASTRO DA PRESTAÇÃO DE CONTAS.')
SET IDENTITY_INSERT [PROJETO].[EAP_ATIVIDADE] OFF
/****** Object:  Table [REQUISITOS].[DOCUMENTO_REQUISITOS_HISTORIA_DE_USUARIO]    Script Date: 07/04/2016 01:59:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [REQUISITOS].[DOCUMENTO_REQUISITOS_HISTORIA_DE_USUARIO](
	[ID_requisitoHistoria] [int] IDENTITY(1,1) NOT NULL,
	[ID_documentoRequisitos] [int] NOT NULL,
	[acao] [nvarchar](800) NOT NULL,
	[funcionalidade] [nvarchar](1000) NOT NULL,
	[dataCadastro] [datetime] NOT NULL,
 CONSTRAINT [PK_REQUISITOS_AADSP_REQUISITO_CASO_DE_USO] PRIMARY KEY CLUSTERED 
(
	[ID_requisitoHistoria] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Default [DF_PROJETO_AADSP_PROJETO_dataCadastro]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[PROJETO] ADD  CONSTRAINT [DF_PROJETO_AADSP_PROJETO_dataCadastro]  DEFAULT (getdate()) FOR [dataCadastro]
GO
/****** Object:  Default [DF__PROJETO_A__inves__6754599E]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[PROJETO] ADD  DEFAULT ((0.00)) FOR [investimento]
GO
/****** Object:  Default [DF_REQUISITOS_AADSP_DOCUMENTO_REQUISITOS_dataCadastro]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [REQUISITOS].[DOCUMENTO_REQUISITOS] ADD  CONSTRAINT [DF_REQUISITOS_AADSP_DOCUMENTO_REQUISITOS_dataCadastro]  DEFAULT (getdate()) FOR [dataCadastro]
GO
/****** Object:  ForeignKey [FK_ACESSO_FUNCAO]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [ACESSO].[ACESSO]  WITH CHECK ADD  CONSTRAINT [FK_ACESSO_FUNCAO] FOREIGN KEY([ID_funcao])
REFERENCES [ACESSO].[FUNCAO] ([ID_funcao])
GO
ALTER TABLE [ACESSO].[ACESSO] CHECK CONSTRAINT [FK_ACESSO_FUNCAO]
GO
/****** Object:  ForeignKey [FK_ACESSO_PAGINA]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [ACESSO].[ACESSO]  WITH CHECK ADD  CONSTRAINT [FK_ACESSO_PAGINA] FOREIGN KEY([ID_pagina])
REFERENCES [ACESSO].[PAGINA] ([ID_pagina])
GO
ALTER TABLE [ACESSO].[ACESSO] CHECK CONSTRAINT [FK_ACESSO_PAGINA]
GO
/****** Object:  ForeignKey [FK_COLABORADOR_AADSP_COLABORADOR_ACESSO_AADSP_USUARIO]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [COLABORADOR].[COLABORADOR]  WITH CHECK ADD  CONSTRAINT [FK_COLABORADOR_AADSP_COLABORADOR_ACESSO_AADSP_USUARIO] FOREIGN KEY([ID_usuario])
REFERENCES [ACESSO].[USUARIO] ([ID_usuario])
GO
ALTER TABLE [COLABORADOR].[COLABORADOR] CHECK CONSTRAINT [FK_COLABORADOR_AADSP_COLABORADOR_ACESSO_AADSP_USUARIO]
GO
/****** Object:  ForeignKey [FK_PROJETO_AADSP_ATA_COLABORADOR_AADSP_COLABORADOR]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[ATA]  WITH CHECK ADD  CONSTRAINT [FK_PROJETO_AADSP_ATA_COLABORADOR_AADSP_COLABORADOR] FOREIGN KEY([ID_colaborador])
REFERENCES [COLABORADOR].[COLABORADOR] ([ID_colaborador])
GO
ALTER TABLE [PROJETO].[ATA] CHECK CONSTRAINT [FK_PROJETO_AADSP_ATA_COLABORADOR_AADSP_COLABORADOR]
GO
/****** Object:  ForeignKey [FK_PROJETO_AADSP_ATA_PROJETO_AADSP_PROJETO]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[ATA]  WITH CHECK ADD  CONSTRAINT [FK_PROJETO_AADSP_ATA_PROJETO_AADSP_PROJETO] FOREIGN KEY([ID_projeto])
REFERENCES [PROJETO].[PROJETO] ([ID_projeto])
GO
ALTER TABLE [PROJETO].[ATA] CHECK CONSTRAINT [FK_PROJETO_AADSP_ATA_PROJETO_AADSP_PROJETO]
GO
/****** Object:  ForeignKey [FK_PROJETO_AADSP_CRONOGRAMA_PROJETO_AADSP_PROJETO]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[CRONOGRAMA]  WITH CHECK ADD  CONSTRAINT [FK_PROJETO_AADSP_CRONOGRAMA_PROJETO_AADSP_PROJETO] FOREIGN KEY([ID_projeto])
REFERENCES [PROJETO].[PROJETO] ([ID_projeto])
GO
ALTER TABLE [PROJETO].[CRONOGRAMA] CHECK CONSTRAINT [FK_PROJETO_AADSP_CRONOGRAMA_PROJETO_AADSP_PROJETO]
GO
/****** Object:  ForeignKey [FK_PROJETO_AADSP_DIAGRAMA_UML_PROJETO_AADSP_DIAGRAMA_UML_TIPO]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[DIAGRAMA_UML]  WITH CHECK ADD  CONSTRAINT [FK_PROJETO_AADSP_DIAGRAMA_UML_PROJETO_AADSP_DIAGRAMA_UML_TIPO] FOREIGN KEY([ID_diagramaUMLTipo])
REFERENCES [PROJETO].[DIAGRAMA_UML_TIPO] ([ID_diagramaUMLTipo])
GO
ALTER TABLE [PROJETO].[DIAGRAMA_UML] CHECK CONSTRAINT [FK_PROJETO_AADSP_DIAGRAMA_UML_PROJETO_AADSP_DIAGRAMA_UML_TIPO]
GO
/****** Object:  ForeignKey [FK_PROJETO_AADSP_DIAGRAMA_UML_PROJETO_AADSP_PROJETO]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[DIAGRAMA_UML]  WITH CHECK ADD  CONSTRAINT [FK_PROJETO_AADSP_DIAGRAMA_UML_PROJETO_AADSP_PROJETO] FOREIGN KEY([ID_projeto])
REFERENCES [PROJETO].[PROJETO] ([ID_projeto])
GO
ALTER TABLE [PROJETO].[DIAGRAMA_UML] CHECK CONSTRAINT [FK_PROJETO_AADSP_DIAGRAMA_UML_PROJETO_AADSP_PROJETO]
GO
/****** Object:  ForeignKey [FK_PROJETO_AADSP_DIAGRAMA_EAP_PROJETO_AADSP_DIAGRAMA_EAP_TIPO]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[EAP]  WITH CHECK ADD  CONSTRAINT [FK_PROJETO_AADSP_DIAGRAMA_EAP_PROJETO_AADSP_DIAGRAMA_EAP_TIPO] FOREIGN KEY([ID_eapTipo])
REFERENCES [PROJETO].[EAP_TIPO] ([ID_eapTipo])
GO
ALTER TABLE [PROJETO].[EAP] CHECK CONSTRAINT [FK_PROJETO_AADSP_DIAGRAMA_EAP_PROJETO_AADSP_DIAGRAMA_EAP_TIPO]
GO
/****** Object:  ForeignKey [FK_PROJETO_AADSP_DIAGRAMA_EAP_PROJETO_AADSP_PROJETO]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[EAP]  WITH CHECK ADD  CONSTRAINT [FK_PROJETO_AADSP_DIAGRAMA_EAP_PROJETO_AADSP_PROJETO] FOREIGN KEY([ID_projeto])
REFERENCES [PROJETO].[PROJETO] ([ID_projeto])
GO
ALTER TABLE [PROJETO].[EAP] CHECK CONSTRAINT [FK_PROJETO_AADSP_DIAGRAMA_EAP_PROJETO_AADSP_PROJETO]
GO
/****** Object:  ForeignKey [FK_PROJETO_AADSP_DIAGRAMA_EAP_ATIVIDADE_PROJETO_AADSP_DIAGRAMA_EAP]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[EAP_ATIVIDADE]  WITH CHECK ADD  CONSTRAINT [FK_PROJETO_AADSP_DIAGRAMA_EAP_ATIVIDADE_PROJETO_AADSP_DIAGRAMA_EAP] FOREIGN KEY([ID_eap])
REFERENCES [PROJETO].[EAP] ([ID_eap])
GO
ALTER TABLE [PROJETO].[EAP_ATIVIDADE] CHECK CONSTRAINT [FK_PROJETO_AADSP_DIAGRAMA_EAP_ATIVIDADE_PROJETO_AADSP_DIAGRAMA_EAP]
GO
/****** Object:  ForeignKey [FK_PROJETO_AADSP_DIAGRAMA_EAP_ATIVIDADE_PROJETO_AADSP_DIAGRAMA_EAP_PACOTE]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[EAP_ATIVIDADE]  WITH CHECK ADD  CONSTRAINT [FK_PROJETO_AADSP_DIAGRAMA_EAP_ATIVIDADE_PROJETO_AADSP_DIAGRAMA_EAP_PACOTE] FOREIGN KEY([ID_eapPacote])
REFERENCES [PROJETO].[EAP_PACOTE] ([ID_eapPacote])
GO
ALTER TABLE [PROJETO].[EAP_ATIVIDADE] CHECK CONSTRAINT [FK_PROJETO_AADSP_DIAGRAMA_EAP_ATIVIDADE_PROJETO_AADSP_DIAGRAMA_EAP_PACOTE]
GO
/****** Object:  ForeignKey [FK_PROJETO_AADSP_DIAGRAMA_EAP_PACOTE_PROJETO_AADSP_PROJETO]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[EAP_PACOTE]  WITH CHECK ADD  CONSTRAINT [FK_PROJETO_AADSP_DIAGRAMA_EAP_PACOTE_PROJETO_AADSP_PROJETO] FOREIGN KEY([ID_projeto])
REFERENCES [PROJETO].[PROJETO] ([ID_projeto])
GO
ALTER TABLE [PROJETO].[EAP_PACOTE] CHECK CONSTRAINT [FK_PROJETO_AADSP_DIAGRAMA_EAP_PACOTE_PROJETO_AADSP_PROJETO]
GO
/****** Object:  ForeignKey [FK_PONTO_COMPLEXIDADE_CONTRIBUICAO_PONTO_COMPLEXIDADE_NIVEL]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[PONTO_COMPLEXIDADE_CONTRIBUICAO]  WITH CHECK ADD  CONSTRAINT [FK_PONTO_COMPLEXIDADE_CONTRIBUICAO_PONTO_COMPLEXIDADE_NIVEL] FOREIGN KEY([ID_complexidadeNivel])
REFERENCES [PROJETO].[PONTO_COMPLEXIDADE_NIVEL] ([ID_complexidadeNivel])
GO
ALTER TABLE [PROJETO].[PONTO_COMPLEXIDADE_CONTRIBUICAO] CHECK CONSTRAINT [FK_PONTO_COMPLEXIDADE_CONTRIBUICAO_PONTO_COMPLEXIDADE_NIVEL]
GO
/****** Object:  ForeignKey [FK_PROJETO_AADSP_PROJETO_PONTO_COMPLEXIDADE_ENTRADAS_EXTERNAS_PROJETO_AADSP_PROJETO_PONTO_COMPLEXIDADE_NIVEL]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[PONTO_COMPLEXIDADE_ENTRADAS_EXTERNAS]  WITH CHECK ADD  CONSTRAINT [FK_PROJETO_AADSP_PROJETO_PONTO_COMPLEXIDADE_ENTRADAS_EXTERNAS_PROJETO_AADSP_PROJETO_PONTO_COMPLEXIDADE_NIVEL] FOREIGN KEY([ID_complexidadeNivel])
REFERENCES [PROJETO].[PONTO_COMPLEXIDADE_NIVEL] ([ID_complexidadeNivel])
GO
ALTER TABLE [PROJETO].[PONTO_COMPLEXIDADE_ENTRADAS_EXTERNAS] CHECK CONSTRAINT [FK_PROJETO_AADSP_PROJETO_PONTO_COMPLEXIDADE_ENTRADAS_EXTERNAS_PROJETO_AADSP_PROJETO_PONTO_COMPLEXIDADE_NIVEL]
GO
/****** Object:  ForeignKey [FK_PONTO_COMPLEXIDADE_SAIDAS_EXTERNAS_PONTO_COMPLEXIDADE_NIVEL]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[PONTO_COMPLEXIDADE_SAIDAS_EXTERNAS]  WITH CHECK ADD  CONSTRAINT [FK_PONTO_COMPLEXIDADE_SAIDAS_EXTERNAS_PONTO_COMPLEXIDADE_NIVEL] FOREIGN KEY([ID_complexidadeNivel])
REFERENCES [PROJETO].[PONTO_COMPLEXIDADE_NIVEL] ([ID_complexidadeNivel])
GO
ALTER TABLE [PROJETO].[PONTO_COMPLEXIDADE_SAIDAS_EXTERNAS] CHECK CONSTRAINT [FK_PONTO_COMPLEXIDADE_SAIDAS_EXTERNAS_PONTO_COMPLEXIDADE_NIVEL]
GO
/****** Object:  ForeignKey [FK_PONTO_CONTAR_FATOR_DE_AJUSTE_PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[PONTO_CONTAR_FATOR_DE_AJUSTE]  WITH CHECK ADD  CONSTRAINT [FK_PONTO_CONTAR_FATOR_DE_AJUSTE_PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS] FOREIGN KEY([ID_caracteristicasGeraisDosSistemas])
REFERENCES [PROJETO].[PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS] ([ID_caracteristicasGeraisDosSistemas])
GO
ALTER TABLE [PROJETO].[PONTO_CONTAR_FATOR_DE_AJUSTE] CHECK CONSTRAINT [FK_PONTO_CONTAR_FATOR_DE_AJUSTE_PONTO_CARACTERISTICAS_GERAIS_DOS_SISTEMAS]
GO
/****** Object:  ForeignKey [FK_PONTO_CONTAR_FATOR_DE_AJUSTE_PONTO_GRAU_INFLUENCIA1]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[PONTO_CONTAR_FATOR_DE_AJUSTE]  WITH CHECK ADD  CONSTRAINT [FK_PONTO_CONTAR_FATOR_DE_AJUSTE_PONTO_GRAU_INFLUENCIA1] FOREIGN KEY([ID_grauInfluencia])
REFERENCES [PROJETO].[PONTO_GRAU_INFLUENCIA] ([ID_grauInfluencia])
GO
ALTER TABLE [PROJETO].[PONTO_CONTAR_FATOR_DE_AJUSTE] CHECK CONSTRAINT [FK_PONTO_CONTAR_FATOR_DE_AJUSTE_PONTO_GRAU_INFLUENCIA1]
GO
/****** Object:  ForeignKey [FK_PONTO_CONTAR_FATOR_DE_AJUSTE_PROJETO]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[PONTO_CONTAR_FATOR_DE_AJUSTE]  WITH CHECK ADD  CONSTRAINT [FK_PONTO_CONTAR_FATOR_DE_AJUSTE_PROJETO] FOREIGN KEY([ID_projeto])
REFERENCES [PROJETO].[PROJETO] ([ID_projeto])
GO
ALTER TABLE [PROJETO].[PONTO_CONTAR_FATOR_DE_AJUSTE] CHECK CONSTRAINT [FK_PONTO_CONTAR_FATOR_DE_AJUSTE_PROJETO]
GO
/****** Object:  ForeignKey [FK_PONTO_CONTAR_TIPO_DADOS_FUNCAO_PONTO_TIPO_DADOS_TIPO]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[PONTO_CONTAR_TIPO_DADOS_FUNCAO]  WITH CHECK ADD  CONSTRAINT [FK_PONTO_CONTAR_TIPO_DADOS_FUNCAO_PONTO_TIPO_DADOS_TIPO] FOREIGN KEY([ID_pontoTipoDados])
REFERENCES [PROJETO].[PONTO_TIPO_DADOS_TIPO] ([ID_pontoTipoDados])
GO
ALTER TABLE [PROJETO].[PONTO_CONTAR_TIPO_DADOS_FUNCAO] CHECK CONSTRAINT [FK_PONTO_CONTAR_TIPO_DADOS_FUNCAO_PONTO_TIPO_DADOS_TIPO]
GO
/****** Object:  ForeignKey [FK_PONTO_CONTAR_TIPO_DADOS_FUNCAO_PROJETO]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[PONTO_CONTAR_TIPO_DADOS_FUNCAO]  WITH CHECK ADD  CONSTRAINT [FK_PONTO_CONTAR_TIPO_DADOS_FUNCAO_PROJETO] FOREIGN KEY([ID_projeto])
REFERENCES [PROJETO].[PROJETO] ([ID_projeto])
GO
ALTER TABLE [PROJETO].[PONTO_CONTAR_TIPO_DADOS_FUNCAO] CHECK CONSTRAINT [FK_PONTO_CONTAR_TIPO_DADOS_FUNCAO_PROJETO]
GO
/****** Object:  ForeignKey [FK_PONTO_CONTAR_TIPO_TRANSACAO_PONTO_TIPO_TRANSACAO_TIPO]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[PONTO_CONTAR_TIPO_TRANSACAO]  WITH CHECK ADD  CONSTRAINT [FK_PONTO_CONTAR_TIPO_TRANSACAO_PONTO_TIPO_TRANSACAO_TIPO] FOREIGN KEY([ID_tipoTransacaoTipo])
REFERENCES [PROJETO].[PONTO_TIPO_TRANSACAO_TIPO] ([ID_tipoTransacaoTipo])
GO
ALTER TABLE [PROJETO].[PONTO_CONTAR_TIPO_TRANSACAO] CHECK CONSTRAINT [FK_PONTO_CONTAR_TIPO_TRANSACAO_PONTO_TIPO_TRANSACAO_TIPO]
GO
/****** Object:  ForeignKey [FK_PONTO_CONTAR_TIPO_TRANSACAO_PROJETO]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[PONTO_CONTAR_TIPO_TRANSACAO]  WITH CHECK ADD  CONSTRAINT [FK_PONTO_CONTAR_TIPO_TRANSACAO_PROJETO] FOREIGN KEY([ID_projeto])
REFERENCES [PROJETO].[PROJETO] ([ID_projeto])
GO
ALTER TABLE [PROJETO].[PONTO_CONTAR_TIPO_TRANSACAO] CHECK CONSTRAINT [FK_PONTO_CONTAR_TIPO_TRANSACAO_PROJETO]
GO
/****** Object:  ForeignKey [FK_PROJETO_AADSP_PROJETO_TAP_AADSP_TAP]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[PROJETO]  WITH CHECK ADD  CONSTRAINT [FK_PROJETO_AADSP_PROJETO_TAP_AADSP_TAP] FOREIGN KEY([ID_tap])
REFERENCES [TAP].[TAP] ([ID_tap])
GO
ALTER TABLE [PROJETO].[PROJETO] CHECK CONSTRAINT [FK_PROJETO_AADSP_PROJETO_TAP_AADSP_TAP]
GO
/****** Object:  ForeignKey [FK_PROJETO_AADSP_PROJETO_RECUROS_ADICIONAIS_PROJETO_AADSP_PROJETO]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [PROJETO].[RECURSOS_ADICIONAIS]  WITH CHECK ADD  CONSTRAINT [FK_PROJETO_AADSP_PROJETO_RECUROS_ADICIONAIS_PROJETO_AADSP_PROJETO] FOREIGN KEY([ID_projeto])
REFERENCES [PROJETO].[PROJETO] ([ID_projeto])
GO
ALTER TABLE [PROJETO].[RECURSOS_ADICIONAIS] CHECK CONSTRAINT [FK_PROJETO_AADSP_PROJETO_RECUROS_ADICIONAIS_PROJETO_AADSP_PROJETO]
GO
/****** Object:  ForeignKey [FK_REQUISITOS_AADSP_DOCUMENTO_REQUISITOS_PROJETO_AADSP_PROJETO]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [REQUISITOS].[DOCUMENTO_REQUISITOS]  WITH CHECK ADD  CONSTRAINT [FK_REQUISITOS_AADSP_DOCUMENTO_REQUISITOS_PROJETO_AADSP_PROJETO] FOREIGN KEY([ID_documentoRequisitosTipo])
REFERENCES [REQUISITOS].[DOCUMENTO_REQUISITOS_TIPO] ([ID_documentoRequisitosTipo])
GO
ALTER TABLE [REQUISITOS].[DOCUMENTO_REQUISITOS] CHECK CONSTRAINT [FK_REQUISITOS_AADSP_DOCUMENTO_REQUISITOS_PROJETO_AADSP_PROJETO]
GO
/****** Object:  ForeignKey [FK_REQUISITOS_AADSP_DOCUMENTO_REQUISITOS_PROJETO_AADSP_PROJETO1]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [REQUISITOS].[DOCUMENTO_REQUISITOS]  WITH CHECK ADD  CONSTRAINT [FK_REQUISITOS_AADSP_DOCUMENTO_REQUISITOS_PROJETO_AADSP_PROJETO1] FOREIGN KEY([ID_projeto])
REFERENCES [PROJETO].[PROJETO] ([ID_projeto])
GO
ALTER TABLE [REQUISITOS].[DOCUMENTO_REQUISITOS] CHECK CONSTRAINT [FK_REQUISITOS_AADSP_DOCUMENTO_REQUISITOS_PROJETO_AADSP_PROJETO1]
GO
/****** Object:  ForeignKey [FK_REQUISITOS_AADSP_REQUISITO_CASO_DE_USO_REQUISITOS_AADSP_DOCUMENTO_REQUISITOS]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [REQUISITOS].[DOCUMENTO_REQUISITOS_HISTORIA_DE_USUARIO]  WITH CHECK ADD  CONSTRAINT [FK_REQUISITOS_AADSP_REQUISITO_CASO_DE_USO_REQUISITOS_AADSP_DOCUMENTO_REQUISITOS] FOREIGN KEY([ID_documentoRequisitos])
REFERENCES [REQUISITOS].[DOCUMENTO_REQUISITOS] ([ID_documentoRequisitos])
GO
ALTER TABLE [REQUISITOS].[DOCUMENTO_REQUISITOS_HISTORIA_DE_USUARIO] CHECK CONSTRAINT [FK_REQUISITOS_AADSP_REQUISITO_CASO_DE_USO_REQUISITOS_AADSP_DOCUMENTO_REQUISITOS]
GO
/****** Object:  ForeignKey [FK_TAP_AADSP_EQUIPE_ACESSO_AADSP_FUNCAO]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [TAP].[EQUIPE]  WITH CHECK ADD  CONSTRAINT [FK_TAP_AADSP_EQUIPE_ACESSO_AADSP_FUNCAO] FOREIGN KEY([ID_funcao])
REFERENCES [ACESSO].[FUNCAO] ([ID_funcao])
GO
ALTER TABLE [TAP].[EQUIPE] CHECK CONSTRAINT [FK_TAP_AADSP_EQUIPE_ACESSO_AADSP_FUNCAO]
GO
/****** Object:  ForeignKey [FK_TAP_AADSP_EQUIPE_TAP_AADSP_TAP]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [TAP].[EQUIPE]  WITH CHECK ADD  CONSTRAINT [FK_TAP_AADSP_EQUIPE_TAP_AADSP_TAP] FOREIGN KEY([ID_tap])
REFERENCES [TAP].[TAP] ([ID_tap])
GO
ALTER TABLE [TAP].[EQUIPE] CHECK CONSTRAINT [FK_TAP_AADSP_EQUIPE_TAP_AADSP_TAP]
GO
/****** Object:  ForeignKey [FK_TAP_AADSP_PATROCINADOR_TAP_AADSP_EMPRESA]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [TAP].[PATROCINADOR]  WITH CHECK ADD  CONSTRAINT [FK_TAP_AADSP_PATROCINADOR_TAP_AADSP_EMPRESA] FOREIGN KEY([ID_empresa])
REFERENCES [TAP].[EMPRESA] ([ID_empresa])
GO
ALTER TABLE [TAP].[PATROCINADOR] CHECK CONSTRAINT [FK_TAP_AADSP_PATROCINADOR_TAP_AADSP_EMPRESA]
GO
/****** Object:  ForeignKey [FK_TAP_AADSP_PATROCINADOR_TAP_AADSP_STAKEHOLDER]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [TAP].[PATROCINADOR]  WITH CHECK ADD  CONSTRAINT [FK_TAP_AADSP_PATROCINADOR_TAP_AADSP_STAKEHOLDER] FOREIGN KEY([ID_stakeholder])
REFERENCES [TAP].[STAKEHOLDER] ([ID_stakeholder])
GO
ALTER TABLE [TAP].[PATROCINADOR] CHECK CONSTRAINT [FK_TAP_AADSP_PATROCINADOR_TAP_AADSP_STAKEHOLDER]
GO
/****** Object:  ForeignKey [FK_TAP_AADSP_PATROCINADOR_TAP_AADSP_TAP]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [TAP].[PATROCINADOR]  WITH CHECK ADD  CONSTRAINT [FK_TAP_AADSP_PATROCINADOR_TAP_AADSP_TAP] FOREIGN KEY([ID_tap])
REFERENCES [TAP].[TAP] ([ID_tap])
GO
ALTER TABLE [TAP].[PATROCINADOR] CHECK CONSTRAINT [FK_TAP_AADSP_PATROCINADOR_TAP_AADSP_TAP]
GO
/****** Object:  ForeignKey [FK_TAP_AADSP_STAKEHOLDER_TAP_TAP_AADSP_STAKEHOLDER]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [TAP].[STAKEHOLDER_TAP]  WITH CHECK ADD  CONSTRAINT [FK_TAP_AADSP_STAKEHOLDER_TAP_TAP_AADSP_STAKEHOLDER] FOREIGN KEY([ID_stakeholder])
REFERENCES [TAP].[STAKEHOLDER] ([ID_stakeholder])
GO
ALTER TABLE [TAP].[STAKEHOLDER_TAP] CHECK CONSTRAINT [FK_TAP_AADSP_STAKEHOLDER_TAP_TAP_AADSP_STAKEHOLDER]
GO
/****** Object:  ForeignKey [FK_TAP_AADSP_STAKEHOLDER_TAP_TAP_AADSP_TAP]    Script Date: 07/04/2016 01:59:48 ******/
ALTER TABLE [TAP].[STAKEHOLDER_TAP]  WITH CHECK ADD  CONSTRAINT [FK_TAP_AADSP_STAKEHOLDER_TAP_TAP_AADSP_TAP] FOREIGN KEY([ID_tap])
REFERENCES [TAP].[TAP] ([ID_tap])
GO
ALTER TABLE [TAP].[STAKEHOLDER_TAP] CHECK CONSTRAINT [FK_TAP_AADSP_STAKEHOLDER_TAP_TAP_AADSP_TAP]
GO
