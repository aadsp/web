package annotations.projeto;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class PontoDeFuncaoNaoAjustados
{

    PontoComplexidadeNivel nivel;
    private String ALI;
    private int totalALI;
    private String AIE;
    private int totalAIE;
    private String EE;
    private int totalEE;
    private String CE;
    private int totalCE;
    private String SE;
    private int totalSE;

    public List<PontoDeFuncaoNaoAjustados> calcularPontoDeFuncaoPorProjeto(PontoContarTipoTransacao contarTipoTransacao, PontoContarTipoDadosFuncao contarTipoDadosFuncao) throws Exception
    {
        List<PontoDeFuncaoNaoAjustados> listaPontoFuncao = new ArrayList<>();
        
        
        
 

        return listaPontoFuncao;
    }

    public String getALI()
    {
        return ALI;
    }

    public void setALI(String ALI)
    {
        this.ALI = ALI;
    }

    public int getTotalALI()
    {
        return totalALI;
    }

    public void setTotalALI(int totalALI)
    {
        this.totalALI = totalALI;
    }

    public String getAIE()
    {
        return AIE;
    }

    public void setAIE(String AIE)
    {
        this.AIE = AIE;
    }

    public int getTotalAIE()
    {
        return totalAIE;
    }

    public void setTotalAIE(int totalAIE)
    {
        this.totalAIE = totalAIE;
    }

    public String getEE()
    {
        return EE;
    }

    public void setEE(String EE)
    {
        this.EE = EE;
    }

    public int getTotalEE()
    {
        return totalEE;
    }

    public void setTotalEE(int totalEE)
    {
        this.totalEE = totalEE;
    }

    public String getCE()
    {
        return CE;
    }

    public void setCE(String CE)
    {
        this.CE = CE;
    }

    public int getTotalCE()
    {
        return totalCE;
    }

    public void setTotalCE(int totalCE)
    {
        this.totalCE = totalCE;
    }

    public String getSE()
    {
        return SE;
    }

    public void setSE(String SE)
    {
        this.SE = SE;
    }

    public int getTotalSE()
    {
        return totalSE;
    }

    public void setTotalSE(int totalSE)
    {
        this.totalSE = totalSE;
    }

}
