package utils;

import java.util.Random;

/**
 *
 * @author Felipe
 */
public class GeradorDeSenha
{

    /**
     * Metódo para geração de uma combinação númerica aleatória de seis digitos
     * entre 100 números inteiros
     *
     * @return é retornada uma combinação númerica aleatória em formato string
     * de seis digitos
     */
    public static String gerarCombinacaoNumerica()
    {
        String combinacao = new String();
        Random random = new Random();
        for (int i = 0; i < 6; i++)
        {
            if (i == 0)
            {
                combinacao = Integer.toString(random.nextInt(100));
            } else
            {
                combinacao += Integer.toString(random.nextInt(100));
            }
        }
        return combinacao;
    }

}
