package razdwatrzy.zzpj.controller.converters;

import org.springframework.core.convert.converter.Converter;
import razdwatrzy.zzpj.form.BonusForm;
import razdwatrzy.zzpj.model.Bonus;

public class BonusFormToBonus implements Converter<BonusForm, Bonus> {

    @Override
    public Bonus convert(BonusForm bonusForm) {
        Bonus bonus = new Bonus();
        bonus.setCampaign(new CampaignFormToCampaign().convert(bonusForm.getCampaign()));
        bonus.setTitle(bonusForm.getTitle());
        bonus.setDescription(bonusForm.getDescription());
        bonus.setPointsToGet(bonusForm.getPointsToGet());
        bonus.setIcon(bonusForm.getIcon());
        return bonus;
    }
}
