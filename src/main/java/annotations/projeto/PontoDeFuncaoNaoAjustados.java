package annotations.projeto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class PontoDeFuncaoNaoAjustados
{

    PontoComplexidadeNivel nivel;

    private int ALI;
    private int AIE;
    private int EE;
    private int CE;
    private int SE;
    private PontoContarTipoTransacao contarTipoTransacao;
    PontoContarTipoDadosFuncao contarTipoDadosFuncao;

    public PontoDeFuncaoNaoAjustados(PontoContarTipoTransacao contarTipoTransacao, PontoContarTipoDadosFuncao contarTipoDadosFuncao)
    {
        this.contarTipoTransacao = contarTipoTransacao;
        this.contarTipoDadosFuncao = contarTipoDadosFuncao;
    }

    public List<PontoDeFuncaoNaoAjustados> calcularPontoDeFuncaoPorProjeto() throws Exception
    {
        List<PontoDeFuncaoNaoAjustados> listaPontoFuncao = new ArrayList<>();

        PontoComplexidadeContribuicao contribuicao = new PontoComplexidadeContribuicao();

        for (PontoComplexidadeContribuicao obj : contribuicao.listar())
        {
            PontoDeFuncaoNaoAjustados pontoFuncao = new PontoDeFuncaoNaoAjustados(contarTipoTransacao, contarTipoDadosFuncao);
            pontoFuncao.setNivel(obj.getNivel());
            List<String> listaElementoCalculado = new ArrayList<>();
            for (PontoContarTipoDadosFuncao obj1 : contarTipoDadosFuncao.listarPorProjeto())
            {
                verficacaoComplexidadeTiposDados(obj1, pontoFuncao, obj);
            }
            for(PontoContarTipoTransacao obj1: contarTipoTransacao.listar())
            {
                verficacaoComplexidadeTiposTransacao(obj1, pontoFuncao, obj);
            }
            
            listaPontoFuncao.add(pontoFuncao);
        }

        return listaPontoFuncao;
    }

    private void verficacaoComplexidadeTiposDados(PontoContarTipoDadosFuncao obj1, PontoDeFuncaoNaoAjustados pontoFuncao, PontoComplexidadeContribuicao obj)
    {

        if (obj1.getTipoDados().getSigla().equals("ALI"))
        {
            if (obj1.getValorTED() >= 1 && obj1.getValorTED() <= 19)
            {
                if (obj1.getValorTER() == 1 && obj.getNivel().getDescricao().equals("BAIXA"))
                {
                    pontoFuncao.setALI(pontoFuncao.getALI() + (obj.getALI() * obj1.getValorTipoDados()));

                } else if (obj1.getValorTER() >= 2 && obj1.getValorTER() <= 5 && obj.getNivel().getDescricao().equals("BAIXA"))
                {
                    pontoFuncao.setALI(pontoFuncao.getALI() + (obj.getALI() * obj1.getValorTipoDados()));

                } else if (obj1.getValorTER() >= 6 && obj.getNivel().getDescricao().equals("MÉDIA"))
                {
                    pontoFuncao.setALI(pontoFuncao.getALI() + (obj.getALI() * obj1.getValorTipoDados()));

                }

            } else if (obj1.getValorTED() >= 20 && obj1.getValorTED() <= 50)
            {
                if (obj1.getValorTER() == 1 && obj.getNivel().getDescricao().equals("BAIXA"))
                {
                    pontoFuncao.setALI(pontoFuncao.getALI() + (obj.getALI() * obj1.getValorTipoDados()));

                } else if (obj1.getValorTER() >= 2 && obj1.getValorTER() <= 5 && obj.getNivel().getDescricao().equals("MÉDIA"))
                {
                    pontoFuncao.setALI(pontoFuncao.getALI() + (obj.getALI() * obj1.getValorTipoDados()));

                } else if (obj1.getValorTER() >= 6 && obj.getNivel().getDescricao().equals("ALTA"))
                {
                    pontoFuncao.setALI(pontoFuncao.getALI() + (obj.getALI() * obj1.getValorTipoDados()));

                }
            } else if (obj1.getValorTED() >= 51)
            {

                if (obj1.getValorTER() == 1 && obj.getNivel().getDescricao().equals("MÉDIA"))
                {
                    pontoFuncao.setALI(pontoFuncao.getALI() + (obj.getALI() * obj1.getValorTipoDados()));

                } else if (obj1.getValorTER() >= 2 && obj1.getValorTER() <= 5 && obj.getNivel().getDescricao().equals("ALTA"))
                {
                    pontoFuncao.setALI(pontoFuncao.getALI() + (obj.getALI() * obj1.getValorTipoDados()));

                } else if (obj1.getValorTER() >= 6 && obj.getNivel().getDescricao().equals("ALTA"))
                {
                    pontoFuncao.setALI(pontoFuncao.getALI() + (obj.getALI() * obj1.getValorTipoDados()));

                }
            }
        }

        if (obj1.getTipoDados().getSigla().equals("AIE"))
        {
            if (obj1.getValorTED() >= 1 && obj1.getValorTED() <= 19)
            {
                if (obj1.getValorTER() == 1 && obj.getNivel().getDescricao().equals("BAIXA"))
                {

                    pontoFuncao.setAIE(pontoFuncao.getAIE() + (obj.getAIE() * obj1.getValorTipoDados()));
                } else if (obj1.getValorTER() >= 2 && obj1.getValorTER() <= 5 && obj.getNivel().getDescricao().equals("BAIXA"))
                {

                    pontoFuncao.setAIE(pontoFuncao.getAIE() + (obj.getAIE() * obj1.getValorTipoDados()));
                } else if (obj1.getValorTER() >= 6 && obj.getNivel().getDescricao().equals("MÉDIA"))
                {

                    pontoFuncao.setAIE(pontoFuncao.getAIE() + (obj.getAIE() * obj1.getValorTipoDados()));
                }

            } else if (obj1.getValorTED() >= 20 && obj1.getValorTED() <= 50)
            {
                if (obj1.getValorTER() == 1 && obj.getNivel().getDescricao().equals("BAIXA"))
                {

                    pontoFuncao.setAIE(pontoFuncao.getAIE() + (obj.getAIE() * obj1.getValorTipoDados()));
                } else if (obj1.getValorTER() >= 2 && obj1.getValorTER() <= 5 && obj.getNivel().getDescricao().equals("MEDIA"))
                {

                    pontoFuncao.setAIE(pontoFuncao.getAIE() + (obj.getAIE() * obj1.getValorTipoDados()));
                } else if (obj1.getValorTER() >= 6 && obj.getNivel().getDescricao().equals("ALTA"))
                {

                    pontoFuncao.setAIE(pontoFuncao.getAIE() + (obj.getAIE() * obj1.getValorTipoDados()));
                }
            } else if (obj1.getValorTED() >= 51)
            {

                if (obj1.getValorTER() == 1 && obj.getNivel().getDescricao().equals("MÉDIA"))
                {

                    pontoFuncao.setAIE(pontoFuncao.getAIE() + (obj.getAIE() * obj1.getValorTipoDados()));
                } else if (obj1.getValorTER() >= 2 && obj1.getValorTER() <= 5 && obj.getNivel().getDescricao().equals("ALTA"))
                {
                    pontoFuncao.setAIE(pontoFuncao.getAIE() + (obj.getAIE() * obj1.getValorTipoDados()));
                }
                else if (obj1.getValorTER() >= 6 && obj.getNivel().getDescricao().equals("ALTA"))
                {

                    pontoFuncao.setAIE(pontoFuncao.getAIE() + (obj.getAIE() * obj1.getValorTipoDados()));
                }
            }
        }
    }
    
    private void verficacaoComplexidadeTiposTransacao(PontoContarTipoTransacao obj1, PontoDeFuncaoNaoAjustados pontoFuncao, PontoComplexidadeContribuicao obj)
    {
        
        if (obj1.getTipoTransacao().getSigla().equals("EE"))
        {
            if (obj1.getValorTED() >= 1 && obj1.getValorTED() <= 4)
            {
                if (obj1.getValorTAR() <= 1 && obj.getNivel().getDescricao().equals("BAIXA"))
                {
                    
                    pontoFuncao.setEE(pontoFuncao.getEE() + (obj.getEE() * obj1.getValorTipoTransacao()));

                } else if (obj1.getValorTAR() == 2  && obj.getNivel().getDescricao().equals("BAIXA"))
                {
                    pontoFuncao.setEE(pontoFuncao.getEE() + (obj.getEE() * obj1.getValorTipoTransacao()));

                } else if (obj1.getValorTAR() >= 3 && obj.getNivel().getDescricao().equals("MÉDIA"))
                {
                    pontoFuncao.setEE(pontoFuncao.getEE() + (obj.getEE() * obj1.getValorTipoTransacao()));

                }

            } else if (obj1.getValorTED() >= 5 && obj1.getValorTED() <= 15)
            {
                if (obj1.getValorTAR() <= 1 && obj.getNivel().getDescricao().equals("BAIXA"))
                {
                    pontoFuncao.setEE(pontoFuncao.getEE() + (obj.getEE() * obj1.getValorTipoTransacao()));

                } else if (obj1.getValorTAR() == 2  && obj.getNivel().getDescricao().equals("MÉDIA"))
                {
                    pontoFuncao.setEE(pontoFuncao.getEE() + (obj.getEE() * obj1.getValorTipoTransacao()));

                } else if (obj1.getValorTAR() >= 3 && obj.getNivel().getDescricao().equals("ALTA"))
                {
                    pontoFuncao.setEE(pontoFuncao.getEE() + (obj.getEE() * obj1.getValorTipoTransacao()));

                }
            } else if (obj1.getValorTED() >= 16)
            {

                if (obj1.getValorTAR() <= 1 && obj.getNivel().getDescricao().equals("MÉDIA"))
                {
                    pontoFuncao.setEE(pontoFuncao.getEE() + (obj.getEE() * obj1.getValorTipoTransacao()));

                } else if (obj1.getValorTAR() == 2  && obj.getNivel().getDescricao().equals("ALTA"))
                {
                    pontoFuncao.setEE(pontoFuncao.getEE() + (obj.getEE() * obj1.getValorTipoTransacao()));

                } else if (obj1.getValorTAR() >= 3 && obj.getNivel().getDescricao().equals("ALTA"))
                {
                    pontoFuncao.setEE(pontoFuncao.getEE() + (obj.getEE() * obj1.getValorTipoTransacao()));

                }
            }
        }
        
        if (obj1.getTipoTransacao().getSigla().equals("ECE"))
        {
            if (obj1.getValorTED() >= 1 && obj1.getValorTED() <= 4)
            {
                if (obj1.getValorTAR() <= 1 && obj.getNivel().getDescricao().equals("BAIXA"))
                {

                    pontoFuncao.setCE(pontoFuncao.getCE() + (obj.getCE() * obj1.getValorTipoTransacao()));
                } else if (obj1.getValorTAR() == 2  && obj.getNivel().getDescricao().equals("BAIXA"))
                {

                    pontoFuncao.setCE(pontoFuncao.getCE() + (obj.getCE() * obj1.getValorTipoTransacao()));
                } else if (obj1.getValorTAR() >= 3 && obj.getNivel().getDescricao().equals("MÉDIA"))
                {

                    pontoFuncao.setCE(pontoFuncao.getCE() + (obj.getCE() * obj1.getValorTipoTransacao()));
                }

            } else if (obj1.getValorTED() >= 5 && obj1.getValorTED() <= 15)
            {
                if (obj1.getValorTAR() <= 1 && obj.getNivel().getDescricao().equals("BAIXA"))
                {

                   pontoFuncao.setCE(pontoFuncao.getCE() + (obj.getCE() * obj1.getValorTipoTransacao()));
                } else if (obj1.getValorTAR() == 2  && obj.getNivel().getDescricao().equals("MÉDIA"))
                {

                   pontoFuncao.setCE(pontoFuncao.getCE() + (obj.getCE() * obj1.getValorTipoTransacao()));
                } else if (obj1.getValorTAR() >= 3 && obj.getNivel().getDescricao().equals("ALTA"))
                {

                    pontoFuncao.setCE(pontoFuncao.getCE() + (obj.getCE() * obj1.getValorTipoTransacao()));
                }
            } else if (obj1.getValorTED() >= 16)
            {

                if (obj1.getValorTAR() <= 1 && obj.getNivel().getDescricao().equals("MÉDIA"))
                {

                   pontoFuncao.setCE(pontoFuncao.getCE() + (obj.getCE() * obj1.getValorTipoTransacao()));
                } else if (obj1.getValorTAR() == 2  && obj.getNivel().getDescricao().equals("ALTA"))
                {
                    pontoFuncao.setCE(pontoFuncao.getCE() + (obj.getCE() * obj1.getValorTipoTransacao()));
                }
                else if (obj1.getValorTAR() >= 3 && obj.getNivel().getDescricao().equals("ALTA"))
                {

                    pontoFuncao.setCE(pontoFuncao.getCE() + (obj.getCE() * obj1.getValorTipoTransacao()));
                }
            }
        }
        
        if (obj1.getTipoTransacao().getSigla().equals("SE"))
        {
            if (obj1.getValorTED() >= 1 && obj1.getValorTED() <= 5)
            {
                if (obj1.getValorTAR() <= 1 && obj.getNivel().getDescricao().equals("BAIXA"))
                {

                    pontoFuncao.setSE(pontoFuncao.getSE() + (obj.getSE() * obj1.getValorTipoTransacao()));
                } else if (obj1.getValorTAR() >= 2 && obj1.getValorTAR() <= 3 && obj.getNivel().getDescricao().equals("BAIXA"))
                {

                    pontoFuncao.setSE(pontoFuncao.getSE() + (obj.getSE() * obj1.getValorTipoTransacao()));
                } else if (obj1.getValorTAR() >= 4  && obj.getNivel().getDescricao().equals("MÉDIA"))
                {

                    pontoFuncao.setSE(pontoFuncao.getSE() + (obj.getSE() * obj1.getValorTipoTransacao()));
                }

            } else if (obj1.getValorTED() >= 6 && obj1.getValorTED() <= 19)
            {
                if (obj1.getValorTAR() <= 1 && obj.getNivel().getDescricao().equals("BAIXA"))
                {

                    pontoFuncao.setSE(pontoFuncao.getSE() + (obj.getSE() * obj1.getValorTipoTransacao()));
                } else if (obj1.getValorTAR() >= 2 && obj1.getValorTAR() <= 3 && obj.getNivel().getDescricao().equals("MÉDIA"))
                {

                    pontoFuncao.setSE(pontoFuncao.getSE() + (obj.getSE() * obj1.getValorTipoTransacao()));
                } else if (obj1.getValorTAR() >= 4  && obj.getNivel().getDescricao().equals("ALTA"))
                {

                    pontoFuncao.setSE(pontoFuncao.getSE() + (obj.getSE() * obj1.getValorTipoTransacao()));
                }
            } else if (obj1.getValorTED() >= 20)
            {

                if (obj1.getValorTAR() <= 1 && obj.getNivel().getDescricao().equals("MÉDIA"))
                {

                    pontoFuncao.setSE(pontoFuncao.getSE() + (obj.getSE() * obj1.getValorTipoTransacao()));
                } else if (obj1.getValorTAR() >= 2 && obj1.getValorTAR() <= 3 && obj.getNivel().getDescricao().equals("ALTA"))
                {
                    pontoFuncao.setSE(pontoFuncao.getSE() + (obj.getSE() * obj1.getValorTipoTransacao()));
                }
                else if (obj1.getValorTAR() >= 4  && obj.getNivel().getDescricao().equals("ALTA"))
                {

                    pontoFuncao.setSE(pontoFuncao.getSE() + (obj.getSE() * obj1.getValorTipoTransacao()));
                }
            }
        }
        
        
        
        if (obj1.getTipoTransacao().getSigla().equals("SCE"))
        {
            if (obj1.getValorTED() >= 1 && obj1.getValorTED() <= 5)
            {
                if (obj1.getValorTAR() <= 1 && obj.getNivel().getDescricao().equals("BAIXA"))
                {

                    pontoFuncao.setCE(pontoFuncao.getCE() + (obj.getCE() * obj1.getValorTipoTransacao()));
                } else if (obj1.getValorTAR() >= 2 && obj1.getValorTAR() <= 3 && obj.getNivel().getDescricao().equals("BAIXA"))
                {

                    pontoFuncao.setCE(pontoFuncao.getCE() + (obj.getCE() * obj1.getValorTipoTransacao()));
                } else if (obj1.getValorTAR() >= 4  && obj.getNivel().getDescricao().equals("MÉDIA"))
                {

                    pontoFuncao.setCE(pontoFuncao.getCE() + (obj.getCE() * obj1.getValorTipoTransacao()));
                }

            } else if (obj1.getValorTED() >= 6 && obj1.getValorTED() <= 19)
            {
                if (obj1.getValorTAR() <= 1 && obj.getNivel().getDescricao().equals("BAIXA"))
                {

                    pontoFuncao.setCE(pontoFuncao.getCE() + (obj.getCE() * obj1.getValorTipoTransacao()));
                } else if (obj1.getValorTAR() >= 2 && obj1.getValorTAR() <= 3 && obj.getNivel().getDescricao().equals("MÉDIA"))
                {

                    pontoFuncao.setCE(pontoFuncao.getCE() + (obj.getCE() * obj1.getValorTipoTransacao()));
                } else if (obj1.getValorTAR() >= 4  && obj.getNivel().getDescricao().equals("ALTA"))
                {

                    pontoFuncao.setCE(pontoFuncao.getCE() + (obj.getCE() * obj1.getValorTipoTransacao()));
                }
            } else if (obj1.getValorTED() >= 20)
            {

                if (obj1.getValorTAR() <= 1 && obj.getNivel().getDescricao().equals("MÉDIA"))
                {

                    pontoFuncao.setCE(pontoFuncao.getCE() + (obj.getCE() * obj1.getValorTipoTransacao()));
                } else if (obj1.getValorTAR() >= 2 && obj1.getValorTAR() <= 3 && obj.getNivel().getDescricao().equals("ALTA"))
                {
                    pontoFuncao.setCE(pontoFuncao.getCE() + (obj.getCE() * obj1.getValorTipoTransacao()));
                }
                else if (obj1.getValorTAR() >= 4  && obj.getNivel().getDescricao().equals("ALTA"))
                {

                    pontoFuncao.setCE(pontoFuncao.getCE() + (obj.getCE() * obj1.getValorTipoTransacao()));
                }
            }
        }
    }
    
    public PontoComplexidadeNivel getNivel()
    {
        return nivel;
    }

    public void setNivel(PontoComplexidadeNivel nivel)
    {
        this.nivel = nivel;
    }

    public int getALI()
    {
        return ALI;
    }

    public void setALI(int ALI)
    {
        this.ALI = ALI;
    }

    public int getAIE()
    {
        return AIE;
    }

    public void setAIE(int AIE)
    {
        this.AIE = AIE;
    }

    public int getEE()
    {
        return EE;
    }

    public void setEE(int EE)
    {
        this.EE = EE;
    }

    public int getCE()
    {
        return CE;
    }

    public void setCE(int CE)
    {
        this.CE = CE;
    }

    public int getSE()
    {
        return SE;
    }

    public void setSE(int SE)
    {
        this.SE = SE;
    }

}
