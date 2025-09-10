public class CompoundInterestCalculator {

    // A) Базовая формула: дискретная капитализация n раз в год
    public static double fvDiscrete(double principal, double apr, int compoundsPerYear, double years) {
        double r = apr;
        int n = compoundsPerYear;
        double t = years;
        return principal * Math.pow(1 + r / n, n * t);
    }

    // C) Будущая стоимость с регулярными взносами PMT (в конце периода = ordinary annuity)
    // Если contributionAtBeginning = true, то взносы в начале периода (annuity due)
    public static double fvWithContributions(double principal, double apr, int compoundsPerYear, double years,
                                             double contributionPerPeriod, boolean contributionAtBeginning) {
        double r = apr;
        int n = compoundsPerYear;
        double t = years;
        double i = r / n;                 // ставка за период
        double periods = n * t;           // всего периодов

        double baseFV = principal * Math.pow(1 + i, periods);

        if (i == 0.0) {
            double contribFV = contributionPerPeriod * periods; 
            return baseFV + contribFV;
        }

        double annuityFactor = (Math.pow(1 + i, periods) - 1) / i;
        double contribFV = contributionPerPeriod * annuityFactor;

        if (contributionAtBeginning) {
            contribFV *= (1 + i);
        }

        return baseFV + contribFV;
    }

    // D) Эффективная годовая ставка (APY/EAR) из APR при дискретной капитализации n раз в год
    public static double effectiveAnnualRate(double apr, int compoundsPerYear) {
        double r = apr;
        int n = compoundsPerYear;
        return Math.pow(1 + r / n, n) - 1;
    }

    // D) Непрерывная капитализация
    public static double fvContinuous(double principal, double apr, double years) {
        return principal * Math.exp(apr * years);
    }

    // D) Реальная ставка доходности с учётом инфляции
    public static double realRate(double nominalRate, double inflationRate) {
        return (1 + nominalRate) / (1 + inflationRate) - 1;
    }

    // D) «Реальная» (в ценах сегодняшнего дня) стоимость будущей суммы при инфляции
    public static double deflateToToday(double futureValue, double inflationRate, double years) {
        return futureValue / Math.pow(1 + inflationRate, years);
    }

    // D) Приближённая будущая стоимость «после налогов»
    public static double afterTaxFutureValue(double futureValue, double principal,
                                             double contributionPerPeriod, int compoundsPerYear,
                                             double years, double taxRate) {
        double basis = principal + contributionPerPeriod * compoundsPerYear * years;
        double gains = Math.max(0.0, futureValue - basis);
        return basis + gains * (1 - taxRate);
    }

    private static String money(double x) {
        return String.format("$%,.2f", x);
    }

    public static void main(String[] args) {
        double principal = 10_000;
        double apr = 0.08;
        int n = 12;
        double years = 5;
        double pmt = 200;
        boolean begin = false;

        double fvNoContrib = fvDiscrete(principal, apr, n, years);
        double fvWithEndContrib = fvWithContributions(principal, apr, n, years, pmt, false);
        double fvWithBeginContrib = fvWithContributions(principal, apr, n, years, pmt, true);
        double ear = effectiveAnnualRate(apr, n);
        double fvCont = fvContinuous(principal, apr, years);

        double assumedInflation = 0.03;
        double realEar = realRate(ear, assumedInflation);
        double realFV_NoContrib = deflateToToday(fvNoContrib, assumedInflation, years);

        double taxRate = 0.20;
        double fvAfterTax = afterTaxFutureValue(fvWithEndContrib, principal, pmt, n, years, taxRate);

        System.out.println("=== Сложные проценты: пример ===");
        System.out.println("Без пополнений (дискретно):        " + money(fvNoContrib));
        System.out.println("С взносами (в конце периода):       " + money(fvWithEndContrib));
        System.out.println("С взносами (в начале периода):      " + money(fvWithBeginContrib));
        System.out.println("Эффективная годовая ставка (APY):   " + String.format("%.2f%%", ear * 100));
        System.out.println("Непрерывная капитализация:          " + money(fvCont));
        System.out.println("Реальная APY (минус инфляция):      " + String.format("%.2f%%", realEar * 100));
        System.out.println("FV без пополнений в ценах сегодня:  " + money(realFV_NoContrib));
        System.out.println("FV с взносами (после налогов):      " + money(fvAfterTax));
    }
}